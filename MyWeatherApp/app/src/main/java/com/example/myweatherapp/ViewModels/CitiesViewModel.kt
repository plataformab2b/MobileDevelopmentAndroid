package com.example.myweatherapp.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CitiesViewModel() :ViewModel() {
    private val repository = AppRepository()

    var cities by mutableStateOf<List<String>>(emptyList())
    private set

    init {
        viewModelScope.launch {
            val fetchCities = repository.getCities("")
            cities = fetchCities
        }
    }

    fun getCities(userTerm: String) : List<String>{
        viewModelScope.launch {
            val fetchCities = repository.getCities(userTerm)
            cities = fetchCities
        }
        return cities
    }

}