package com.example.base_library.net_1.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * 统一添加header
 */
class NetworkInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        return chain.proceed(chain.request().newBuilder().apply {
            method(original.method, original.body)

            /*//header替换
            removeHeader("Authorization")
            addHeader("Authorization", "")*/
            removeHeader("User-Agent")
//            addHeader("User-Agent", "")
        }.build())
    }
}