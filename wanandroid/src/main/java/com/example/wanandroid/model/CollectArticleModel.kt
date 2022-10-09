package com.example.wanandroid.model

import com.example.wanandroid.presenter.HomePresenter

interface CollectArticleModel {

    /**
     * add or remove collect article
     */
    fun collectArticle(
        onCollectArticleListener: HomePresenter.OnCollectArticleListener,
        id: Int,
        isAdd: Boolean
    )

    /**
     * cancel collect article Request
     */
    fun cancelCollectRequest()
}