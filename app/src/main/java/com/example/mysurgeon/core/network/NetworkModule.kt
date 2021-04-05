package com.example.mysurgeon.core.network

import com.example.mysurgeon.core.service.API
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkModule {

    private var client: OkHttpClient? = null

    private fun provideHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        client = OkHttpClient.Builder()
            .followRedirects(false)
            .addNetworkInterceptor(httpLoggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()
        return client!!
    }

    fun retrofit(): Retrofit {
        val gsonBuilder = GsonBuilder()
            .setLenient()
        val httpLoggingInterceptor = provideHttpLoggingInterceptor()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
            .baseUrl(BASE_URL)
            .client(provideHttpClient(httpLoggingInterceptor))
            .build()
    }

    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    fun provideApi(): API {
        val retrofit = retrofit()
        return retrofit.create(API::class.java)
    }
    companion object {
        private var INSTANCE: NetworkModule? = null
        const val BASE_URL = "http://s193933.gridserver.com/resources/library/"

        fun getInstance(): NetworkModule {
            if (INSTANCE == null) {
                INSTANCE = NetworkModule()
            }
            return INSTANCE!!
        }
    }
}