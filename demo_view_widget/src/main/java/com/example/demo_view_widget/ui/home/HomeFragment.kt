package com.example.demo_view_widget.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demo_view_widget.circle_view.CircleViewDialogFragment
import com.example.demo_view_widget.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val mVB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = mVB.root

        val textView: TextView = mVB.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        initView()
        return root
    }

    private fun initView() {
        mVB.ifb.setOnClickListener {
            CircleViewDialogFragment().showThis(childFragmentManager, Bundle())
        }
        mVB.likeView.onClickListener = object : MyClickListener {
            override fun oneClick() {

            }

            override fun doubleClick() {

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

interface MyClickListener {
    fun oneClick()
    fun doubleClick()
}