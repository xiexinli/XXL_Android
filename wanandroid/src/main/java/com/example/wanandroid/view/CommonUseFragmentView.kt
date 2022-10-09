package com.example.wanandroid.view

import com.example.wanandroid.bean.FriendListResponse
import com.example.wanandroid.bean.HotKeyResponse

/**
 * CommonUse Fragment View interface
 */
interface CommonUseFragmentView {
    /**
     * get Friend list Success
     */
    fun getFriendListSuccess(
        bookmarkResult: FriendListResponse?,
        commonResult: FriendListResponse,
        hotResult: HotKeyResponse
    )

    /**
     * get Friend list Failed
     */
    fun getFriendListFailed(errorMessage: String?)

    /**
     * get Friend list data size equal zero
     */
    fun getFriendListZero()
}