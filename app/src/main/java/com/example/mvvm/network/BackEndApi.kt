package com.example.mvvm.network


import com.example.mvvm.model.User
import retrofit2.Call

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface BackEndApi {
    @FormUrlEncoded
    @POST("/api/v1/register")
    fun registerData(@Field("email") email: String, @Field("password") password: String):
            Call<User>

    @FormUrlEncoded
    @POST("/api/v1/login")
    fun loginData(@Field("email")email:String, @Field("password") password: String):
        Call<User>
}