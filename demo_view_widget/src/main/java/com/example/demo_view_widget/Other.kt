package com.example.demo_view_widget

import android.content.Context
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

fun changeBgColor(iv: ImageView?, context: Context) {
    iv?.let {//修改图片资源颜色
        DrawableCompat.setTint(
            //不想影响到该图片其他地方的使用，要添加mutate()方法
            DrawableCompat.wrap(it.drawable).mutate(),
            ContextCompat.getColor(context, R.color.black)
        )
    }
}