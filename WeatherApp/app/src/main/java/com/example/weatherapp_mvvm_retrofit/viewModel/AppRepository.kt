package com.example.weatherapp_mvvm_retrofit.viewModel

import com.example.weatherapp_mvvm_retrofit.RoomDB.City
import com.example.weatherapp_mvvm_retrofit.RoomDB.CityDAO
import com.example.weatherapp_mvvm_retrofit.data.RetrofitClass
import com.example.weatherapp_mvvm_retrofit.data.WeatherObject

class AppRepository(private val cityDao: CityDAO) {

    private val apiService = RetrofitClass.api
    private val weatherApiService = RetrofitClass.weatherApi

    suspend fun getCities(query: String): List<String>{
        return apiService.getCities(query)
    }

    suspend fun getWeather(city: String): WeatherObject?{
        return  weatherApiService.getWeather(city,"071c3ffca10be01d334505630d2c1a9c", "metric")
    }

     suspend fun getCitiesFromDB(): List<City>{
        return cityDao.getAllCities()
    }

    suspend fun insertCity(c:City){
        cityDao.insertCityToDB(c)
    }

    suspend fun deleteCity(c:City){
        cityDao.deleteCity(c)
    }

    suspend fun searchForCityInDB(term:String) : List<City>{
        return cityDao.getCityNamed(term)
    }
//// 44, Toronto, ON, Canda
    // 44, Toronto, Canada
    suspend fun update(newCity: City){
        return cityDao.updateCity(newCity)// 44, Toronto, ON, Canda
    }


}