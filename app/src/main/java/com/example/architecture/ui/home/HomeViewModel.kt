package com.example.architecture.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base_library.net_1.HttpClient
import com.example.base_library.net_1.createCall
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val dataNetOne = MutableLiveData<String>()
    fun getNetData() {
        viewModelScope.launch {
            val netResult = createCall {
                HttpClient.getService().getListArticle(null)
            }
        }
    }
}