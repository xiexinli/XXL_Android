package com.example.base_library.net_1

import android.text.TextUtils
import com.alibaba.fastjson.JSON
import com.example.base_library.net_1.interceptor.*
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

        fun getInstance(): HttpClient {
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

    fun <T> create(service: Class<T>): T {
        return mRetrofit.create(service)
    }

//    fun getService(): HttpService {
//        return create(HttpService::class.java)
//    }

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