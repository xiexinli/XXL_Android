package com.example.wanandroid.view

import com.example.wanandroid.bean.HomeListResponse

interface CollectArticleView {

    /**
     * add article success
     * @param result HomeListResponse
     * @param isAdd true add, false remove
     */
    fun collectArticleSuccess(result: HomeListResponse, isAdd: Boolean)

    /**
     * add article false
     * @param errorMessage error message
     * @param isAdd true add, false remove
     */
    fun collectArticleFailed(errorMessage: String?, isAdd: Boolean)
}