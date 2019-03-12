package com.example.gyc.libdemo.mvvm.model

import com.example.gyc.libdemo.utils.RxSchedulers
import com.example.gyc.libdemo.net.model.ClientBean
import com.example.gyc.libdemo.net.BodyFactory
import com.example.gyc.libdemo.net.HttpClient
import io.reactivex.disposables.Disposable

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-21 下午 4:51
 */
object ClientModel {
    fun getClient(success: (ClientBean) -> Unit, error: (String) -> Unit): Disposable {
        return HttpClient.getApi()
            .getClient(BodyFactory.generalBody("GetClients"))
            .compose(RxSchedulers.ioMain())
            .subscribe({ t ->
                success.invoke(t)
            }, { e ->
                error.invoke(e.toString())
            })
    }
}