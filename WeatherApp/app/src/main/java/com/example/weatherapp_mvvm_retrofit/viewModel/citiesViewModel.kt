package com.example.weatherapp_mvvm_retrofit.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp_mvvm_retrofit.RoomDB.City
import com.example.weatherapp_mvvm_retrofit.data.WeatherObject
import kotlinx.coroutines.launch

class citiesViewModel(private val repository: AppRepository) : ViewModel() {

    var cities by mutableStateOf<List<String>>(emptyList())
    private set


    var dbcities by mutableStateOf<List<City>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            val fetchCities = repository.getCities("")
            cities = fetchCities

            val citiesFromDB = repository.getCitiesFromDB()
            dbcities = citiesFromDB
        }
    }

//    init {
//        viewModelScope.launch {
//            val citiesFromDB = repository.getCitiesFromDB()
//            dbcities = citiesFromDB
//        }
//    }



    fun getCities(userTerm: String) :List<String>{
        viewModelScope.launch {
            val fetchCities = repository.getCities(userTerm)
            cities = fetchCities
        }
        return cities
    }

    fun getDBCities() :List<City>{
        viewModelScope.launch {
            val dbfetchCities = repository.getCitiesFromDB()
            dbcities = dbfetchCities
        }
        return dbcities
    }

    fun insertToDB(c:City){
        viewModelScope.launch {
            repository.insertCity(c)
            val dbfetchCities = repository.getCitiesFromDB()
            dbcities = dbfetchCities
        }
    }

    fun update(newCity: City){
        viewModelScope.launch {
            repository.update(newCity)
            val dbfetchCities = repository.getCitiesFromDB()
            dbcities = dbfetchCities
        }
    }
    fun deleteOneCity(c:City){
        viewModelScope.launch {
            repository.deleteCity(c)
            val dbfetchCities = repository.getCitiesFromDB()
            dbcities = dbfetchCities
        }
    }

    fun handleNavigationArguments(arguments: Bundle) {
        // Handle navigation arguments here
    }

}
