package com.example.architecture.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.base_library.cancelByActive
import com.example.base_library.data.HomeListResponse
import com.example.base_library.net_1.HttpClient
import com.example.base_library.net_1.createCall
import com.example.base_library.net_2.RetrofitHelper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val dataNetOne = MutableLiveData<String>()
    fun getNetData() {
        viewModelScope.launch {
            createCall {
                HttpClient.getService().getListArticle()
            }.let {
                dataNetOne.postValue(it.toString())
            }
        }
    }

    private var homeListAsync: Deferred<HomeListResponse>? = null
    fun getNetDataByNet2() {
        viewModelScope.launch {
            homeListAsync?.cancelByActive()
            homeListAsync = RetrofitHelper.retrofitService.getHomeListAsync(1)
            val result = homeListAsync?.await()
            result ?: let {
                dataNetOne.postValue("error\n\n" + result.toString())
            }
            dataNetOne.postValue("success\n\n" + result.toString())
        }

    }
}