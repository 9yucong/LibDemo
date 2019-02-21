package com.example.gyc.libdemo.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-21 下午 5:27
 */
open class BaseViewModel : ViewModel() {
    val baseDisposable = CompositeDisposable()

    override fun onCleared() {
        baseDisposable.clear()
    }
}