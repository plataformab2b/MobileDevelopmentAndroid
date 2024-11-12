package com.example.weatherapp_mvvm_retrofit.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class ViewModelFactory(private val repository: AppRepository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(citiesViewModel::class.java)){
            return citiesViewModel(repository) as T
        }else {
            throw IllegalArgumentException("Error")
        }
    }
    }


class WeatherViewModelFactory(private val repository: AppRepository):
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WeatherViewModel::class.java)){
            return WeatherViewModel(repository) as T
        }else {
            throw IllegalArgumentException("Error")
        }
    }
}