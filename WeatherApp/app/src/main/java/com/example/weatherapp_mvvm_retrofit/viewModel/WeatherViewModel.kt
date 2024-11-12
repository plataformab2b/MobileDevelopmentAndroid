package com.example.weatherapp_mvvm_retrofit.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp_mvvm_retrofit.data.WeatherObject
import kotlinx.coroutines.launch

class WeatherViewModel( private val repository: AppRepository) : ViewModel()  {


    var weatherO by mutableStateOf<WeatherObject?>(null)
        private set

    fun getWeather(city: String){
        viewModelScope.launch {
            try {
                var weatherObj = repository.getWeather(city)
                if (weatherObj != null) {
                    weatherO = weatherObj
                }
            }catch (e : Exception) {
                Log.d("error", e.toString())
            }
        }
    }
}