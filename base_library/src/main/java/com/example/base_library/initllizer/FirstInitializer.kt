package com.example.base_library.initllizer

import android.content.Context
import androidx.startup.Initializer
import com.example.base_library.base.Preference

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
 * */
class FirstInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Preference.setContext(context)
//        BaseApplication.setContext(context)
//
//        GlobalScope.launch(Dispatchers.IO) {
//            MMKV.initialize(context)
//            MMKVUtils.initMMKV(context)
//
//            withContext(Dispatchers.Main) {
//                ABTestUtil.getInstance()//ab分流初始化，不能调用初始化之后立即获取分流
//            }
//
//            //TdSdkUtil.init()
//
//            BuyerConfig.SECURIT_PRO //在使用它之前默认调用下，会减少第一次调用SECURIT_PRO的耗时
//
//            AkamaiUtil.initialize(BaseApplication.getInstance())
//        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }

//    //检查MMKV是否初始化(防止前面在子线程中MMKV没有初始化，影响后续功能)
//    companion object {
//        fun checkAndInitMMKV() {
//            if (!MMKV.getRootDir().isNullOrEmpty()) return
//
//            MMKV.initialize(BaseApplication.getInstance())
//            MMKVUtils.initMMKV(BaseApplication.getInstance())
//        }
//    }
}