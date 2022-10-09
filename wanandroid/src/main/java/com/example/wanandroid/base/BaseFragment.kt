package com.example.wanandroid.base

import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {

    protected var isFirst: Boolean = true

    /**
     * cancel request
     */
    protected abstract fun cancelRequest()

    override fun onDestroyView() {
        super.onDestroyView()
        cancelRequest()
    }
}