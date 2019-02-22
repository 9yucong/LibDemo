package com.example.gyc.libdemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.gyc.libdemo.RxSchedulers
import com.example.gyc.libdemo.base.BaseViewModel
import io.reactivex.Observable
import io.reactivex.rxkotlin.addTo
import java.util.concurrent.TimeUnit

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 5:52
 */
class TestViewModel : BaseViewModel() {

    fun getTask(): MutableLiveData<String> {
        val clientLiveData = MutableLiveData<String>()
        Observable.interval(0, 2, TimeUnit.SECONDS)
            .compose(RxSchedulers.ioMain())
            .subscribe { t ->
                Log.d("Test", "t==$t")
                clientLiveData.value = t.toString()
            }
            .addTo(baseDisposable)
        return clientLiveData
    }
}