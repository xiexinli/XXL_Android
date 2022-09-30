package com.example.base_library.net_1.interceptor

import com.example.base_library.net_1.*
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * 修改域名
 */
class UrlInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        // 获取request
        val request: Request = chain.request()
        // 从request中获取原有的HttpUrl实例oldHttpUrl
        val oldHttpUrl: HttpUrl = request.url
        // 获取request的创建者builder
        val builder: Request.Builder = request.newBuilder()
        // 从request中获取headers，通过给定的键url_name
        val headerValues: List<String> = request.headers("url")
        if (headerValues.isNotEmpty()) {
            // 如果有这个header，先将配置的header删除，因此header仅用作app和okhttp之间使用
            builder.removeHeader("url")
            // 匹配获得新的BaseUrl
            val newBaseUrl = when (headerValues[0]) {
                "mrd" -> {
                    (API_SCHEME + API_MRD).toHttpUrl()
                }
                "app" -> {
                    (API_SCHEME + API_APP).toHttpUrl()
                }
                else -> {
                    (API_SCHEME + API_WWW).toHttpUrl()
                }
            }
//            val newBaseUrl2 = if (newBaseUrl.isHttps) { //切换域名
//                val newHost =""
//                (API_SCHEME + newHost).toHttpUrl()
//            } else {
//                newBaseUrl
//            }
            // 重建新的HttpUrl，修改需要修改的url部分
            val newFullUrl: HttpUrl = oldHttpUrl
                .newBuilder()
                // 更换网络协议
                .scheme(newBaseUrl.scheme)
                // 更换主机名
                .host(newBaseUrl.host)
                .build()
            // 重建这个request，通过builder.url(newFullUrl).build()
            // 然后返回一个response至此结束修改
            return chain.proceed(builder.url(newFullUrl).build())
        }
        return chain.proceed(request)
    }
}