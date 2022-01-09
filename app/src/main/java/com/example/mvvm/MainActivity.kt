package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.LoginViewModel

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var viewmodel: LoginViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=DataBindingUtil. setContentView(this,R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding?.viewmodel = viewmodel
    }

}



