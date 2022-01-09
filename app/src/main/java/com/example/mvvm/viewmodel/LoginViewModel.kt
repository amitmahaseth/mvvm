package com.example.mvvm.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import com.example.mvvm.model.User
import com.example.mvvm.network.BackEndApi
import com.example.mvvm.network.WebServiceClient
import com.example.mvvm.util.Util
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(application: Application) : AndroidViewModel(application) {
    var btnSelected: ObservableBoolean? = null
    var btnSign: ObservableBoolean? = null
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null

    init {
        btnSign = ObservableBoolean(false)
        btnSelected = ObservableBoolean(false)
        email = ObservableField("")
        password = ObservableField("")

    }

    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(s.toString()) && password?.get()!!.length >= 8)
    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(Util.isEmailValid(email?.get()!!) && s.toString().length >= 8)
    }

    fun login() {
        WebServiceClient.getInstance().create(BackEndApi::class.java).loginData(
            email = email?.get()!!, password = password?.get()!!
        )
            .enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    response.body()
                    Log.d("login", "true")
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {

                }
            })

    }

    fun sign() {
        WebServiceClient.getInstance().create(BackEndApi::class.java).registerData(
            email = email?.get()!!, password = password?.get()!!
        )
            .enqueue(object : Callback<User?> {
                override fun onResponse(call: Call<User?>, response: Response<User?>) {
                    response.body()
                    Log.d("Sign", "true")
                }

                override fun onFailure(call: Call<User?>, t: Throwable) {
                    Log.d("Sign", "false")

                }
            })

    }
}