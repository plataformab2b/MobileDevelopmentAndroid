package com.example.weatherapp_mvvm_retrofit.viewModel

import com.example.weatherapp_mvvm_retrofit.data.RetrofitClass
import com.example.weatherapp_mvvm_retrofit.data.WeatherObject

class AppRepository {
    private val apiService = RetrofitClass.api
    private val weatherApiService = RetrofitClass.weatherApi

    suspend fun getCities(query: String): List<String>{
        return apiService.getCities(query)
    }

    suspend fun getWeather(city: String): WeatherObject?{
        return  weatherApiService.getWeather(city,"071c3ffca10be01d334505630d2c1a9c", "metric")
    }
}