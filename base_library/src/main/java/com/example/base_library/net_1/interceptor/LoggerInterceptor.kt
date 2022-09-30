package com.example.base_library.net_1.interceptor

import android.util.Log
import com.example.base_library.BuildConfig
import com.example.base_library.getUrlPath
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import okio.BufferedSource
import java.io.IOException
import java.nio.charset.Charset
import kotlin.jvm.Throws

/**
 * 日志打印
 */
class LoggerInterceptor : Interceptor {
    private val LOG_TAG = "LoggerInterceptor"

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response: Response = chain.proceed(request)
        Log.d(LOG_TAG, getUrlPath(request.url.toString()))
        //错误日志上报
        val body = response.body
        val source: BufferedSource
        if (body != null) {
            source = body.source()
            source.request(Long.MAX_VALUE) // Buffer the entire body.

            val buffer = source.buffer
            var charset = Charset.defaultCharset()
            val contentType = body.contentType()
            if (contentType != null) {
                charset = contentType.charset(charset)
            }
        }

        val requestStartMessage = "--> " + request.method + ' ' + request.url + ' ' + request
        val sb = StringBuilder()
        sb.append(requestStartMessage)
        if (BuildConfig.DEBUG) {
            if (request.body is FormBody) {
                val body = (request.body) as FormBody
                for (i in 0 until body.size) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",")
                }
                sb.delete(sb.length - 1, sb.length)
            }
            val result = sb.toString()
            if (result.length > 4000) {
                var i = 0
                while (i < result.length) {
                    if (i + 4000 < result.length) Log.i(
                        LOG_TAG + i,
                        result.substring(i, i + 4000)
                    ) else Log.i(LOG_TAG + i, result.substring(i, result.length))
                    i += 4000
                }
            } else Log.d(LOG_TAG, result)
        }
        return response
    }
}