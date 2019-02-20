package com.example.gyc.libdemo.net

import com.example.gyc.libdemo.bean.ClientBean
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST


/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 2:41
 */
interface ApiService{
    @POST("api.php")
    fun getPosts(@Body body: RequestBody): Observable<ClientBean>
}