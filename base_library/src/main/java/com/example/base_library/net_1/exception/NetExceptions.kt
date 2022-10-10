package com.example.base_library.net_1.exception

import com.example.base_library.net_1.*
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

object NetExceptions {
    fun handleException(e: Throwable): SelfDefineHttpException {
        val ex: SelfDefineHttpException
        //解析错误
        return when (e) {
            is HttpException -> { //HTTP错误
                ex = SelfDefineHttpException(e, err_0x0222)
                ex.setMessage(e.message())
                ex
            }
            is SelfDefineHttpException -> {    //服务器返回的错误
                val resultException: SelfDefineHttpException = e
                ex = SelfDefineHttpException(resultException, resultException.state)
                val msg: String? = resultException.message
                ex.setMessage(msg)
                ex
            }
            is JsonParseException, is JSONException, is ParseException, is JsonSyntaxException -> {
                ex = SelfDefineHttpException(e, err_0x0106)
                ex.setMessage(e.message)
                ex
            }
            is ConnectException, is UnknownHostException -> {//网络错误
                ex = SelfDefineHttpException(e, err_0x1111)
                //            ex.setMessage(MyApplication.getInstance().getString(R.string.system_error_title))
                ex
            }
            is SocketTimeoutException -> {
                ex = SelfDefineHttpException(e, err_0x1111)
                //            ex.setMessage(MyApplication.getInstance().getString(R.string.server_busy))
                ex
                //        } else if (e is AkamaiChallengeException) { //Akamai challenge异常
                //            ex = SelfDefineHttpException(e, ErrorCode.err_0x428)
                //            ex
            }
            else -> {
                ex = SelfDefineHttpException(e, err_0x0106)
                //            ex.setMessage(MyApplication.getInstance().getString(R.string.system_error_title)) //未知错误
                ex
            }
        }
    }
}