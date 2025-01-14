package com.example.weatherapp_mvvm_retrofit.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {

    @GET("AutoCompleteCity")
    suspend fun getCities(@Query("q") q: String): List<String>

    @GET("weather?")
    suspend fun getWeather(@Query("q") q: String,
                           @Query("appid") key: String,
                           @Query("units") units: String): WeatherObject


}