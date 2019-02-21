package com.example.gyc.libdemo.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 5:55
 */
abstract class BaseFragment <T:ViewModel> : Fragment() {
    private lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(setViewModel())
    }

    abstract fun setViewModel(): Class<T>
}