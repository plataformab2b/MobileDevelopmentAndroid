package com.example.myweatherapp.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitClass {

   val api : APIInterface by lazy {
       val retrofit = Retrofit.
       Builder().
       addConverterFactory(GsonConverterFactory.create()).
       baseUrl("http://gd.geobytes.com/").build()

       retrofit.create(APIInterface::class.java)
   }

    val weatherApi: APIInterface by lazy {
        val retrofit = Retrofit.
        Builder().
        addConverterFactory(GsonConverterFactory.create()).
        baseUrl("https://api.openweathermap.org/data/2.5/").build()
        retrofit.create(APIInterface::class.java)
    }




}