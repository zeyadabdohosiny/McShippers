package com.example.mcshippers.base.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

var retrofitModule = module {
    fun getInstance(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor).build()
        return Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/Bassem-Samy/")
//            .addConverterFactory(APIResponseConverter())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    }
    single { getInstance() }
}