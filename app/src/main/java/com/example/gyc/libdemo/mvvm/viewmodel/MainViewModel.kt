package com.example.gyc.libdemo.mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.gyc.libdemo.mvvm.model.ClientModel
import com.example.gyc.libdemo.base.BaseViewModel
import io.reactivex.rxkotlin.addTo

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 5:52
 */
class MainViewModel : BaseViewModel() {
    private val clientLiveData by lazy {
        MutableLiveData<String>()
    }

    fun getClient(): MutableLiveData<String> {
        ClientModel.getClient({ result ->
            Log.d("11111", result.toString())
        }, { e ->
            Log.d("11111", e)
        }).addTo(baseDisposable)
        return clientLiveData
    }
}