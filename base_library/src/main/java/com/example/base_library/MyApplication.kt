package com.example.base_library

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class MyApplication : Application() {
//    companion object {
//        private lateinit var instance: Application
//        fun getInstance(): Application {
//            return instance
//        }
//    }

    override fun onCreate() {
        super.onCreate()
//        instance = this
        initARouter()
    }

    private fun initARouter() {
        ARouter.init(this)
        ARouter.openLog()
        ARouter.openDebug()
    }
}