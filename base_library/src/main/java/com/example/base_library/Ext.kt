package com.example.base_library

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import com.example.base_library.net_2.Net2Constants
import kotlinx.coroutines.Deferred
import kotlin.coroutines.cancellation.CancellationException

/**
 * Log
 */
fun loge(tag: String, content: String?) {
    Log.e(tag, content ?: tag)
}

/**
 * show toast
 * @param content String
 */
@SuppressLint("ShowToast")
fun Context.toast(content: String) {
    Net2Constants.showToast?.apply {
        setText(content)
        show()
    } ?: run {
        Toast.makeText(this.applicationContext, content, Toast.LENGTH_SHORT).apply {
            Net2Constants.showToast = this
        }.show()
    }
}

/**
 * show toast
 * @param id strings.xml
 */
fun Context.toast(@StringRes id: Int) {
    toast(getString(id))
}

fun Deferred<Any>?.cancelByActive() = this?.run {
    tryCatch {
        if (isActive) {
            cancel()
        }
    }
}

/**
 * save cookie string
 */
fun encodeCookie(cookies: List<String>): String {
    val sb = StringBuilder()
    val set = HashSet<String>()
    cookies
        .map { cookie ->
            cookie.split(";".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }
        .forEach {
            it.filterNot { set.contains(it) }.forEach { set.add(it) }
        }

    val ite = set.iterator()
    while (ite.hasNext()) {
        val cookie = ite.next()
        sb.append(cookie).append(";")
    }

    val last = sb.lastIndexOf(";")
    if (sb.length - 1 == last) {
        sb.deleteCharAt(last)
    }

    return sb.toString()
}

/**
 * get random color
 * @return 16777215 is FFFFFF, 0 is 000000
 */
fun getRandomColor(): String = "#${Integer.toHexString((Math.random() * 16777215).toInt())}"

///**
// * getAgentWeb
// */
//fun String.getAgentWeb(
//    activity: Activity, webContent: ViewGroup,
//    layoutParams: ViewGroup.LayoutParams,
//    receivedTitleCallback: ChromeClientCallbackManager.ReceivedTitleCallback?
//) = AgentWeb.with(activity)//传入Activity or Fragment
//    .setAgentWebParent(webContent, layoutParams)//传入AgentWeb 的父控件
//    .useDefaultIndicator()// 使用默认进度条
//    .defaultProgressBarColor() // 使用默认进度条颜色
//    .setReceivedTitleCallback(receivedTitleCallback) //设置 Web 页面的 title 回调
//    .createAgentWeb()//
//    .ready()
//    .go(this)!!

/**
 * LayoutInflater.from(this).inflate
 * @param resource layoutId
 * @return View
 */
fun Context.inflater(@LayoutRes resource: Int): View =
    LayoutInflater.from(this).inflate(resource, null)

/**
 * In disappear assist cheng (cancel) will be submitted to the Job Cancellation Exception Exception.
 */
inline fun tryCatch(catchBlock: (Throwable) -> Unit = {}, tryBlock: () -> Unit) {
    try {
        tryBlock()
//    } catch (_: JobCancellationException) {
    } catch (_:CancellationException) {

    } catch (t: Throwable) {
        catchBlock(t)
    }
}