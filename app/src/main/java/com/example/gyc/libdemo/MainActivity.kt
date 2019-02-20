package com.example.gyc.libdemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gyc.libdemo.net.BodyFactory
import com.example.gyc.libdemo.net.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HttpClient.getApi()
            .getPosts(BodyFactory.generalBody("GetClients"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ t ->
                Log.d("11111", t.toString())
            }, { e ->
                Log.d("11111", e.toString())
            })
    }
}
