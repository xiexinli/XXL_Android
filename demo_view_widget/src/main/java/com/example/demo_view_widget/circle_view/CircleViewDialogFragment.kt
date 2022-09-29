package com.example.demo_view_widget.circle_view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.base_library.base.BaseBottomDialogFragment
import com.example.demo_view_widget.databinding.FragmentCircleViewBinding

class CircleViewDialogFragment : BaseBottomDialogFragment<FragmentCircleViewBinding>() {

    override fun initView() {

    }

    override fun bindData() {

    }

    override fun initDataObserver() {

    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCircleViewBinding.inflate(inflater)
}