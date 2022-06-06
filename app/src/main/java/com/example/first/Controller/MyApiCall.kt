package com.example.first.Controller

import com.example.first.Model.Users
import com.google.gson.JsonElement
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface MyApiCall  {

    @GET("contacts")
    fun getUsers() : Call<JsonElement>

    companion object {

        val BASE_URL = "https://api.androidhive.info/"

        fun create() : MyApiCall {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(MyApiCall::class.java)

        }

    }

}