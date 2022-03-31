package com.example.network.retrofit

import com.example.network.config.ConfigApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkInicialization {
     var retrofitBuilder = Retrofit.Builder()
        .baseUrl(ConfigApi.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(apiService: Class<T>) = retrofitBuilder.create(apiService)
}
