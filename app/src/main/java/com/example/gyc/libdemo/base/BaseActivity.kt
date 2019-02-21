package com.example.gyc.libdemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 5:55
 */
abstract class BaseActivity<T:ViewModel> : AppCompatActivity() {
    lateinit var baseViewModel: T
    override fun onCreate(savedInstanceState: Bundle?) {
        baseViewModel = ViewModelProviders.of(this).get(setViewModel())
        super.onCreate(savedInstanceState)
    }

    abstract fun setViewModel(): Class<T>
}