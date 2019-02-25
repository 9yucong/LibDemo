package com.example.gyc.libdemo.net

import android.support.test.runner.AndroidJUnit4
import android.util.Log
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Description:
 *
 * @author: gaoyucong
 * Date: 2019-02-22 下午 3:50
 */
@RunWith(AndroidJUnit4::class)
class HttpClientTest {
    @Test
    fun testHttpClientUnique() {
        val obj1 = HttpClient.getApi()
        val obj2 = HttpClient.getApi()
        Log.d("testHttpClientUnique",obj1.toString())
        Log.d("testHttpClientUnique",obj2.toString())
        assertSame(obj1, obj2)
    }
}