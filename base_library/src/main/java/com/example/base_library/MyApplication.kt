package com.example.base_library

import android.app.Application

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
    }
}