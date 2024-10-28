package com.example.myweatherapp.Data

data class WeatherObj(val main: mObje,
                         val weather: List<wObje>,
                         val name: String) {
}
data class wObje( val main: String,
                  val description: String ,
                  val icon: String ){}

data class mObje( var temp: Double ,
                  var feels_like: Double ) {}