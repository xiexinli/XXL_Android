package com.example.demo_view_widget.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.demo_view_widget.TestAActivity
import com.example.demo_view_widget.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val mVB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = mVB.root

        val textView: TextView = mVB.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        initOther()
        return root
    }

    private fun initOther() {
        val testAActivity = TestAActivity()

        val testAClass = TestAActivity::class.java
        val aField = testAClass.getDeclaredField("testB")
        aField.isAccessible = true
        aField.setBoolean(testAActivity, true)

        mVB.ifb.setOnClickListener {
            startActivity(Intent(context, TestAActivity::class.java))
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}