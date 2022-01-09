package com.example.mvvm.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebServiceClient {

    val BASE_URL="https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}