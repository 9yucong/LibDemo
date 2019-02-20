package com.example.gyc.libdemo.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 5:11
 */
open class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        compositeDisposable.clear()
    }
}