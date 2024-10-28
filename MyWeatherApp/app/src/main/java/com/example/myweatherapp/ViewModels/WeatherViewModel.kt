package com.example.myweatherapp.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myweatherapp.Data.WeatherObj
import kotlinx.coroutines.launch

class WeatherViewModel() : ViewModel() {
    private val repository = AppRepository()

    var weatherObj by mutableStateOf<WeatherObj?>(null)
        private set

    init {
        viewModelScope.launch {
            val fetchedWeather = repository.getWeather("Toronto,ON,Canada")
            weatherObj = fetchedWeather
        }
    }

    fun getWeatherData(city: String) : WeatherObj?{
        viewModelScope.launch {
            val fetchedWeather = repository.getWeather(city)
            weatherObj = fetchedWeather
        }
        return weatherObj
    }

}