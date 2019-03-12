package com.example.gyc.libdemo.net

import com.example.gyc.libdemo.net.model.ClientBean
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
    companion object {
        private const val BASE_PATH="api.php"
    }

    @POST(BASE_PATH)
    fun getClient(@Body body: RequestBody): Observable<ClientBean>
}