package com.example.weatherapp_mvvm_retrofit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp_mvvm_retrofit.RoomDB.City
import com.example.weatherapp_mvvm_retrofit.Views.AlertComposable
import com.example.weatherapp_mvvm_retrofit.Views.TopBar
import com.example.weatherapp_mvvm_retrofit.ui.theme.WeatherAppMVVMRetrofitTheme
import com.example.weatherapp_mvvm_retrofit.viewModel.AppRepository
import com.example.weatherapp_mvvm_retrofit.viewModel.ViewModelFactory
import com.example.weatherapp_mvvm_retrofit.viewModel.citiesViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = CityDataBase.getInstance(applicationContext)
        val repository = AppRepository(database.getCityDao())
        val myviewModelFactory = ViewModelFactory(repository)
        val myViewModel = ViewModelProvider(this, myviewModelFactory)[citiesViewModel::class.java]

        setContent {
            WeatherAppMVVMRetrofitTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = { TopBar(myViewModel) },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "cityList",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("cityList") {
                            CityListScreen(myViewModel, navController)
                        }
                        composable("weather/{city}") { backStackEntry ->
                            val city = backStackEntry.arguments?.getString("city")
                            if (city != null) {
                                WeatherScreen(city)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CityListScreen(vm: citiesViewModel, navController: NavHostController) {
    var selectedIndex by remember { mutableStateOf(-1) }
    var showAlert by remember { mutableStateOf(false) }
    val context = LocalContext.current

    ListOfCities(
        list = vm.cities,
        onCitySelected = { index ->
            selectedIndex = index
            showAlert = true
        }
    )

    if (showAlert) {
        AlertComposable(
            onWeather = {
                navController.navigate("weather/${vm.cities[selectedIndex]}")
                showAlert = false
            },
            onSave = {
                vm.insertToDB(City(Math.random().toInt(), vm.cities[selectedIndex]))
                showAlert = false
                navController.navigate("weather/${vm.cities[selectedIndex]}")
            }
        )
    }
}

@Composable
fun ListOfCities(list: List<String>, onCitySelected: (Int) -> Unit) {
    LazyColumn {
        items(list.size) { id ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { onCitySelected(id) },
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = list[id])
            }
        }
    }
}

@Composable
fun WeatherScreen(city: String) {
    // Implement the WeatherScreen composable function
}
