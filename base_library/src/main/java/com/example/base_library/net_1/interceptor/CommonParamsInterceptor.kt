package com.example.base_library.net_1.interceptor

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class CommonParamsInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val builder: HttpUrl.Builder = request.url.newBuilder()

        //添加公用参数
        builder.addQueryParameter("time", System.currentTimeMillis().toString())
        val newRequest: Request = request.newBuilder()
            .url(builder.build())
            .build()
        return chain.proceed(newRequest)
    }
}