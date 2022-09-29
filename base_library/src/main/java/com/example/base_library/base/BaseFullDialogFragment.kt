package com.example.base_library.base

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.ScreenUtils
import com.example.base_library.R

/**
 * 全屏DialogFragment
 * */
abstract class BaseFullDialogFragment<VB : ViewBinding> : DialogFragment() {
    val TAG = this::class.java.simpleName
    private lateinit var mVB: VB

    fun showThis(fragmentManager: FragmentManager?, bundle: Bundle?) {
        fragmentManager ?: return
        bundle ?: return

        try {
            fragmentManager.findFragmentByTag(TAG)?.let {
                if (it.isResumed) return
                if (it.isAdded) fragmentManager.beginTransaction().remove(it).commitNow()
            }
            arguments = bundle
            showNow(fragmentManager, TAG)
        } catch (e: Exception) {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.window?.setWindowAnimations(R.style.down_to_up)
        mVB = getViewBinding(inflater, container)

        initView()
        bindData()
        initDataObserver()
        return mVB.root
    }

    abstract fun initView()

    abstract fun bindData()

    abstract fun initDataObserver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.dialog_bottom_full)
    }

    override fun onStart() {
        super.onStart()
        dialog?.run {
            setCancelable(true)
            setCanceledOnTouchOutside(true)
            window?.run {
                setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                setGravity(Gravity.BOTTOM)
                mVB.root.layoutParams?.apply {
                    height = ScreenUtils.getScreenHeight() * 3 / 4
//                    height = ScreenUtils.getScreenHeight()
                }
            }
        }
    }

    protected abstract fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?): VB
}