package com.example.architecture.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.architecture.MainViewModel
import com.example.architecture.databinding.FragmentHomeBinding
import com.example.base_library.logeXXL1

class HomeFragment : Fragment() {
    private val mVM by viewModels<HomeViewModel>()
    private val mVMActivity by viewModels<MainViewModel>({ requireActivity() })

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        mVM.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

//        mVM.getNetData()

        mVM.getNetDataByNet2()

        mVMActivity.dataMainTest1.observe(requireActivity()) {
            logeXXL1(this, it)
        }

        initDataObserver()
        return root
    }

    private fun initDataObserver() {
        mVM.dataNetOne.observe(viewLifecycleOwner) {
            binding.textHome.text = it
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}