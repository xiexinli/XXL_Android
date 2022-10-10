package com.example.base_library.initllizer

import android.content.Context
import androidx.startup.Initializer

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
class XtremeInitializer : Initializer<Unit> {
    override fun create(context: Context) {
//        XtremeRecevier.initPush(context as Application)
//
//        GlobalScope.launch(Dispatchers.IO) {
//            while (PushConnector.mPushConnector == null) {
//                delay(40)
//            }
//
//            try { //xtreme push id
//                PushConnector.mPushConnector?.run {
//                    getDeviceInfo(context)[MMKVConfigs.XPUSHDEVICEID]?.apply {
//                        DHLogUtil.e("PushConnector.mPushConnector deviceInfo************$this")
//                        MMKVUtils.saveXPushId(this)
//                    }
//                    LoginDao.getLoginDto()?.user?.userid?.apply {
//                        if (!TextUtils.isEmpty(this)) setUser(this)
//                        hitTag("user_login_date", DHDateUtil.getDateNow())
//                    }
//                }
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf(FirstInitializer::class.java)
    }
}