package com.kmdev.bakingapp.retrofit

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Kajal_Mittal on 02/07/17.
 */
object RestService{
    private val CONNECTION_TIMEOUT: Long = 30
    private val API_URL = "http://food2fork.com/api/"

    fun getService(): Rest {
        val client = getOkHttpClient()
        val rest = Retrofit.Builder().baseUrl(API_URL).client(client)
                .addConverterFactory(GsonConverterFactory.create()).build().create(Rest::class.java)
        return rest
    }

    private fun getOkHttpClient(): OkHttpClient {
        val okClientBuilder = OkHttpClient.Builder()
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        okClientBuilder.addInterceptor(httpLoggingInterceptor)
        okClientBuilder.addNetworkInterceptor(StethoInterceptor())
        okClientBuilder.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        okClientBuilder.readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        okClientBuilder.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
        return okClientBuilder.build()
    }
}
