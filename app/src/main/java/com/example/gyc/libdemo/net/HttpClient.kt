package com.example.gyc.libdemo.net

import android.content.Context
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.Internal.instance
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.lang.NullPointerException
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.TimeUnit
import okhttp3.logging.HttpLoggingInterceptor
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.Interceptor


/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-19 下午 4:12
 */
class HttpClient private constructor() {
    //url对应retrofit存储在map中
    private val retrofitMap = ConcurrentHashMap<String, Retrofit>()
    private val apiServiceMap = ConcurrentHashMap<String, ApiService>()
    private var baseUrl: String? = null

    companion object {
        private val instance: HttpClient
            get() = SingletonHolder.INSTANCE

        fun init(context: Context): Builder {
            return Builder(context, instance)
        }

        fun getApi(): ApiService {
            instance.baseUrl.let {
                if (it == null) {
                    throw NullPointerException("没有使用baseUrl设置默认url")
                } else {
                    return getApi(it)
                }
            }
        }

        /**
         * 根据url返回apiService对象
         */
        fun getApi(url: String): ApiService {
            instance.apiServiceMap[url].let {
                if (it == null) {
                    throw NullPointerException("没有使用addUrl根据url设置apiService")
                } else {
                    return it
                }
            }
        }
    }


    private fun baseUrl(url: String, okHttpClient: OkHttpClient) {
        baseUrl = url
        addUrl(url, okHttpClient)
    }

    private fun addUrl(url: String, okHttpClient: OkHttpClient) {
        val retrofit = newRetrofit(url, okHttpClient)
        retrofitMap[url] = retrofit
        apiServiceMap[url] = retrofit.create(ApiService::class.java)
    }

    /**
     * 新增OkHttpClient对象
     */
    private fun newOkHttpClient(context: Context): OkHttpClient {
        // init cache
        val cacheFile = File(context.applicationContext.cacheDir, "cache")
        val cache = Cache(cacheFile, 1024 * 1024 * 100) //100Mb
        // init okhttp 3 logger
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addInterceptor(logInterceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(55, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }

    /**
     * 新增Retrofit对象
     */
    private fun newRetrofit(url: String, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private object SingletonHolder {
        val INSTANCE = HttpClient()
    }

    class Builder(context: Context, private var httpClient: HttpClient) {
        private var okHttpClient: OkHttpClient = httpClient.newOkHttpClient(context)

        fun baseUrl(url: String): Builder {
            httpClient.baseUrl(url, okHttpClient)
            return this
        }

        fun addUrl(url: String): Builder {
            httpClient.addUrl(url, okHttpClient)
            return this
        }
    }
}