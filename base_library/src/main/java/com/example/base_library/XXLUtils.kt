package com.example.base_library

import android.net.Uri
import android.text.TextUtils

/**
 * 获取url的路径
 * @param url
 * @return
 */
fun getUrlPath(url: String?): String {
    var path = ""
    if (TextUtils.isEmpty(url)) {
        return path
    }
    try {
        val mUri = Uri.parse(url)
        path = mUri.path.toString()
    } catch (e: Exception) {
        e.printStackTrace()
    }
    return path
}