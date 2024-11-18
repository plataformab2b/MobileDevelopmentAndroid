package com.example.weatherapp_mvvm_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.weatherapp_mvvm_retrofit.RoomDB.CityDataBase
import com.example.weatherapp_mvvm_retrofit.ui.theme.WeatherAppMVVMRetrofitTheme
import com.example.weatherapp_mvvm_retrofit.viewModel.AppRepository
import com.example.weatherapp_mvvm_retrofit.viewModel.WeatherViewModel
import com.example.weatherapp_mvvm_retrofit.viewModel.WeatherViewModelFactory

class WeatherActivity : ComponentActivity() {
    private val myViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = CityDataBase.getInstance(applicationContext)
        val repository = AppRepository(database.getCityDao())
        val myviewModelFactory = WeatherViewModelFactory(repository)
        val myViewModel = ViewModelProvider(this, myviewModelFactory)[WeatherViewModel::class.java]

        val city = intent.getStringExtra("city")
        if (city != null) {
            myViewModel.getWeather(city)
        }

        setContent {
            WeatherAppMVVMRetrofitTheme {
                enableEdgeToEdge()
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "weatherScreen"
                ) {
                    composable("weatherScreen") {
                        if (city != null) {
                            WeatherScreen(myViewModel)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun WeatherScreen(vm: WeatherViewModel) {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val wo = vm.weatherO
        if (wo != null) {
            if (wo.weather?.isNotEmpty() == true) {
                Text(
                    text = wo.name,
                    fontSize = 40.sp,
                )
                Spacer(Modifier.fillMaxHeight(0.2f))
                wo.weather?.get(0)?.let {
                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/${it.icon}@2x.png",
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(0.4f)
                    )
                }
                Spacer(Modifier.fillMaxHeight(0.2f))
                wo.weather?.get(0)?.let {
                    Text(
                        fontSize = 30.sp,
                        text = it.main
                    )
                }
                Spacer(Modifier.fillMaxHeight(0.1f))
                Text(
                    fontSize = 30.sp,
                    text = wo.main?.temp.toString()
                )
                Text(
                    fontSize = 30.sp,
                    text = "Feels Like " + wo.main?.feels_like.toString()
                )
            }
        }
    }
}
