package com.example.base_library.initllizer

import android.content.Context
import androidx.startup.Initializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * 初始化：
 *
 * 1.延迟初始化：
 * <meta-data
 * android:name="com.dhgate.buyermob.initllizer.DHInitializer"
 * tools:node="remove" />
 *
 * AppInitializer.getInstance(this).initializeComponent(DHInitializer::class.java)
 *
 * 处理init消息
 *
 * */
class CNCInitializer : Initializer<Unit> {
    override fun create(context: Context) {

        GlobalScope.launch(Dispatchers.IO) {
//            //每次初始化的时候cnc先置为true
//            MMKVUtils.encode(MMKVConfigs.CNC_SDK_SUC, true)
//
//            //理论上一个自然日内只会发起一次网络鉴权（可能较耗时），为避免在 SDK 内部发起网络鉴权请求，建议在 app 启动时调用：
//            CNCMediaPlayerAuthentication.requestAuth(context, BuyerConfig.CNC_ID,
//                BuyerConfig.CNC_KEY, object : ValidListener {
//                    override fun onInfo(i: Int, s: String) {}
//
//                    override fun onError(i: Int, s: String) {
//                        MMKVUtils.encode(MMKVConfigs.CNC_SDK_SUC, false)
//                    }
//
//                    override fun onComplete(i: Int, s: String) {
//                    }
//                })
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(FirstInitializer::class.java)
    }
}