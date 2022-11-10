package com.demomaster.kotlin.postData

import androidx.viewbinding.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

    private val CONNECTION_TIMEOUT: Long = 2 * 1000 * 60
    private val READ_WRITE_TIMEOUT: Long = 1000 * 60
    private const val BASE_URL: String = "https://reqres.in"

    private val client = OkHttpClient.Builder()
        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
        .readTimeout(READ_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        .writeTimeout(READ_WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        })
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun<T> buildService (service: Class<T>): T{
        return retrofit.create(service)
    }
}