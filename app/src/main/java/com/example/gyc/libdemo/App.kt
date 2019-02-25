package com.example.gyc.libdemo

import android.app.Application
import com.example.gyc.libdemo.manager.DBManager
import com.example.gyc.libdemo.net.HttpClient

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-19 下午 4:05
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        HttpClient.init(this).baseUrl("http://base.chriscn.cn:180/includes/")
        DBManager.init(this)
    }
}