package com.example.demo_view_widget

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.demo_view_widget.databinding.ActivityTestABinding

class TestAActivity : AppCompatActivity() {
    private var testA = "111111111"
    private var testB = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vb = ActivityTestABinding.inflate(layoutInflater)
        setContentView(vb.root)
        Log.e("xxl", "onCreate: ------------$testB")
    }

    override fun onResume() {
        super.onResume()
        Log.e("xxl", "onResume: ------------$testB")
    }
}