package com.example.myweatherapp.ViewModels

import com.example.myweatherapp.Data.RetrofitClass
import com.example.myweatherapp.Data.WeatherObj

class AppRepository {
    private val apiService = RetrofitClass.api
    private val weatherApiService = RetrofitClass.weatherApi

    suspend fun getCities(query : String): List<String> {
       return apiService.getCities(query)
    }

    suspend fun getWeather(city: String): WeatherObj?{
        return  weatherApiService.getWeather(city,"071c3ffca10be01d334505630d2c1a9c", "metric")
    }




}