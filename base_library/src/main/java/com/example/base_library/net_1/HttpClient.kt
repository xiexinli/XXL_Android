package com.example.base_library.net_1

import android.text.TextUtils
import com.alibaba.fastjson.JSON
import com.example.base_library.net_1.exception.NetExceptions
import com.example.base_library.net_1.interceptor.*
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpClient private constructor() {
    private var mRetrofit: Retrofit

    companion object {
        /*超时时间-默认60秒*/
        private const val CONNECTION_TIME = 60L

        /*超时时间-默认60秒*/
        private const val READ_TIME = 60L

        private fun getInstance(): HttpClient {
            return SingletonHolder.INSTANCE
        }

        fun getService(): HttpService {
            return SingletonHolder.INSTANCE.create(HttpService::class.java)
        }
    }

    init {
        val builder = OkHttpClient.Builder()
        builder.apply {
            connectTimeout(CONNECTION_TIME, TimeUnit.SECONDS)
            readTimeout(READ_TIME, TimeUnit.SECONDS)
            addInterceptor(TimeInterceptor())//部分接口超时时间配置
            addInterceptor(UrlInterceptor())//修改域名
            addInterceptor(LoggerInterceptor())//日志打印
            addNetworkInterceptor(NetworkInterceptor())//统一添加header
            addNetworkInterceptor(CommonParamsInterceptor())//公参
        }
        mRetrofit = Retrofit.Builder()
            .baseUrl(API_SCHEME + API_WWW)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    private fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }

    private fun getService(): HttpService {
        return create(HttpService::class.java)
    }

    private object SingletonHolder {
        val INSTANCE: HttpClient = HttpClient()
    }

    fun isJSON(str: String?): Boolean {
        if (TextUtils.isEmpty(str))
            return false
        val result = try {
            JSON.parse(str)
            true
        } catch (e: Exception) {
            false
        }
        return result
    }

}

suspend inline fun <T> createCall(crossinline call: suspend CoroutineScope.() -> NetResultBean<T>): NetResource<T> {
    return withContext(Dispatchers.Main) {
        var reslut: NetResource<T> = NetResource.error("unknow", data = null)
        var resultDto: NetResultBean<T>? = null
        val ref = async {//注意async一定为根协程才能在await时捕获异常
            call()
        }
        try {
            resultDto = ref.await()
        } catch (e: Exception) {
            e.printStackTrace()
            val ex = NetExceptions.handleException(e)
            reslut = NetResource.error(ex.message, ex.state, null)
        } catch (e: CancellationException) {
            reslut = NetResource.error(e.message, "0x9999", null)
        }
        resultDto?.apply {
            if (TextUtils.equals(state, err_0x0000)) {
                reslut = NetResource.success(data = data, err_0x0000, serverTime)
            } else {
//                if (TextUtils.equals(state, NetErrorCode.err_0x0002)) {
//                    try {
//                        withContext(Dispatchers.IO) {
//                            //session过期，如果已经登录，则重新登录
//                            if (LoginDao.getLoginDto() != null) {
//                                HttpUtil.setLogintimes(HttpUtil.getLogintimes() + 1)
//                                if (HttpUtil.getLogintimes() < 5) {
//                                    autoLogin()
//                                } else {
//                                    LoginDao.setLoginDto(null)
//                                }
//                            }
//                        }
//                    } catch (e: Exception) {
//                        e.printStackTrace()
//                        LoginDao.setLoginDto(null)
//                    }
//                }
                reslut = NetResource.error(message, state, data, serverTime)
            }
        }
        reslut
    }
}