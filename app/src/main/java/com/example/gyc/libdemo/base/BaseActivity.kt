package com.example.gyc.libdemo.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 5:55
 */
abstract class BaseActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModel
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        viewModel = ViewModelProviders.of(this).get(setViewModel()::class.java)
    }

    abstract fun setViewModel(): ViewModel
}