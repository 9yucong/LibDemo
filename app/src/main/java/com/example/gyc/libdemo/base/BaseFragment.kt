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
abstract class BaseFragment : Fragment() {
    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(setViewModel()::class.java)
    }

    abstract fun setViewModel(): ViewModel
}