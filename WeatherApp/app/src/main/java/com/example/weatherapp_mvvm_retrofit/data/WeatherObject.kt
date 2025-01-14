package com.example.weatherapp_mvvm_retrofit.data

data class WeatherObject(val main: mObje,
                         val weather: List<wObje>,
                         val name: String) {
}
data class wObje( val main: String,
                  val description: String ,
                  val icon: String ){}

data class mObje( var temp: Double ,
                var feels_like: Double ) {}
