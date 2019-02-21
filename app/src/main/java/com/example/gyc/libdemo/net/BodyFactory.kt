package com.example.gyc.libdemo.net

import okhttp3.MultipartBody
import okhttp3.RequestBody

/**
 * Description:
 * @author: gaoyucong
 * Date: 2019-02-20 下午 4:53
 */
object BodyFactory {
    private const val IDENTIFIER = "cKinrTfylVeBDNAYa76qIkWSjnKDtcfl"
    private const val SECRET = "j2gZqkNdkQLi8VM8TksCr1tZUUuM1gl7"
    private const val ACCESS_KEY = "secret_key_passphrase_goes_here"
    private const val RESPONSE_TYPE = "json"

    /**
     * 生成通用requestBody
     * 以form-data形式发送数据
     */
    fun generalBody(action: String): RequestBody {
        return MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart("action", action)
            .addFormDataPart("username", IDENTIFIER)
            .addFormDataPart("password", SECRET)
            .addFormDataPart("responsetype", RESPONSE_TYPE)
            .addFormDataPart("accesskey", ACCESS_KEY)
            .build()
    }
}