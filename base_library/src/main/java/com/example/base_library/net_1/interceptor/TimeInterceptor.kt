package com.example.base_library.net_1.interceptor

import com.example.base_library.net_1.*
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * 超时时间配置
 */
class TimeInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestUrl = request.url.toString()
        val isUpdateTime = requestUrl.contains(API_IMPACT)
        if (isUpdateTime) {
            return chain.withConnectTimeout(30, TimeUnit.SECONDS)
                .withReadTimeout(30, TimeUnit.SECONDS)
                .withWriteTimeout(30, TimeUnit.SECONDS)
                .proceed(request)
        }
        val isLimitCouponTime = requestUrl.contains("xxx")
        if (isLimitCouponTime) {
            return chain.withConnectTimeout(1500, TimeUnit.MILLISECONDS)
                .withReadTimeout(1500, TimeUnit.MILLISECONDS)
                .proceed(request)
        }
        return chain.proceed(request)
    }
}