package com.example.wanandroid.presenter

import com.example.wanandroid.bean.FriendListResponse
import com.example.wanandroid.bean.HotKeyResponse
import com.example.wanandroid.model.HomeModel
import com.example.wanandroid.model.HomeModelImpl
import com.example.wanandroid.view.CommonUseFragmentView

class CommonUseFragmentPresenterImpl(private val commonUseFragmentView: CommonUseFragmentView) :
    HomePresenter.OnFriendListListener {

    private val homeModel: HomeModel = HomeModelImpl()
    /**
     * get friend tree list
     */
    override fun getFriendList() {
        homeModel.getFriendList(this)
    }

    /**
     * get friend list success
     */
    override fun getFriendListSuccess(
        bookmarkResult: FriendListResponse?,
        commonResult: FriendListResponse,
        hotResult: HotKeyResponse
    ) {
        if (commonResult.errorCode != 0 || hotResult.errorCode != 0) {
            commonUseFragmentView.getFriendListFailed(commonResult.errorMsg)
            return
        }
        if (commonResult.data == null || commonResult.data == null) {
            commonUseFragmentView.getFriendListZero()
            return
        }
        if (commonResult.data?.size == 0 && hotResult.data?.size == 0) {
            commonUseFragmentView.getFriendListZero()
            return
        }
        commonUseFragmentView.getFriendListSuccess(bookmarkResult, commonResult, hotResult)
    }

    /**
     * get friend list failed
     * @param errorMessage error message
     */
    override fun getFriendListFailed(errorMessage: String?) {
        commonUseFragmentView.getFriendListFailed(errorMessage)
    }

    /**
     * cancel request
     */
    fun cancelRequest() {
        homeModel.cancelFriendRequest()
    }
}