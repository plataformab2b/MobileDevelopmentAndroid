package com.example.myweatherapp.Data

import retrofit2.http.GET
import retrofit2.http.Query


interface APIInterface {

    @GET("AutoCompleteCity")
    suspend fun getCities(@Query("q") q: String) : List<String>


    @GET("weather?")
    suspend fun getWeather(@Query("q") q: String,
                           @Query("appid") appid: String,
                           @Query("units") units: String
                               ) : WeatherObj



}