package com.example.gyc.libdemo

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.gyc.libdemo.base.BaseActivity
import com.example.gyc.libdemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity<MainViewModel>() {
    override fun setViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        baseViewModel.getClient().observe(this, Observer { t ->
            tv.text = t
        })
        button.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }
    }
}
