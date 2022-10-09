package com.example.wanandroid.presenter

import com.example.wanandroid.bean.TreeListResponse
import com.example.wanandroid.model.HomeModel
import com.example.wanandroid.model.HomeModelImpl
import com.example.wanandroid.view.TypeFragmentView

class TypeFragmentPresenterImpl(private val typeFragmentView: TypeFragmentView) :
    HomePresenter.OnTypeTreeListListener {

    private val homeModel: HomeModel = HomeModelImpl()
    /**
     * get type tree list
     */
    override fun getTypeTreeList() {
        homeModel.getTypeTreeList(this)
    }

    /**
     * get type tree list success
     * @param result result
     */
    override fun getTypeTreeListSuccess(result: TreeListResponse) {
        if (result.errorCode != 0) {
            typeFragmentView.getTypeListFailed(result.errorMsg)
            return
        }
        if (result.data.isEmpty()) {
            typeFragmentView.getTypeListZero()
            return
        }
        typeFragmentView.getTypeListSuccess(result)
    }

    /**
     * get type tree list failed
     * @param errorMessage error message
     */
    override fun getTypeTreeListFailed(errorMessage: String?) {
        typeFragmentView.getTypeListFailed(errorMessage)
    }

    /**
     * cancel request
     */
    fun cancelRequest() {
        homeModel.cancelTypeTreeRequest()
    }
}