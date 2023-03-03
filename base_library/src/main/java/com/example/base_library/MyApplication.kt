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

        //调试模式不是必须开启，但是为了防止有用户开启了InstantRun，
        //忘了开调试模式，导致无法使用Demo，如果使用了InstantRun，必须在
        //初始化之前开启调试模式，但是上线前需要关闭，InstantRun仅用于开
        //发阶段，线上开启调试模式有安全风险，可以使用BuildConfig.DEBUG
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
        }
    }
}