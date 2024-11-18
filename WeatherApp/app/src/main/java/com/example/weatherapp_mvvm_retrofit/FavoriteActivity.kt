package com.example.weatherapp_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp_mvvm_retrofit.RoomDB.City
import com.example.weatherapp_mvvm_retrofit.RoomDB.CityDataBase
import com.example.weatherapp_mvvm_retrofit.Views.AlertComposable
import com.example.weatherapp_mvvm_retrofit.Views.TopBar
import com.example.weatherapp_mvvm_retrofit.ui.theme.WeatherAppMVVMRetrofitTheme
import com.example.weatherapp_mvvm_retrofit.viewModel.AppRepository
import com.example.weatherapp_mvvm_retrofit.viewModel.ViewModelFactory
import com.example.weatherapp_mvvm_retrofit.viewModel.citiesViewModel

class FavoriteActivity : ComponentActivity()  {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = CityDataBase.getInstance(applicationContext)
        val repository = AppRepository(database.getCityDao())
        val myviewModelFactory = ViewModelFactory(repository)
        val myViewModel = ViewModelProvider(this,myviewModelFactory)[citiesViewModel::class.java]

        setContent {
            WeatherAppMVVMRetrofitTheme {
                val navController = rememberNavController()
                Scaffold(
                    topBar = {
                        TopAppBar(title= { Text("Favorite Cities ") })
                    },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "favoriteList",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("favoriteList") {
                            ListOfDBCities(
                                list = myViewModel.getDBCities(),
                                modifier = Modifier.padding(innerPadding), myViewModel, navController
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun ListOfDBCities(list: List<City>,
                       modifier: Modifier = Modifier,
                       vm: citiesViewModel,
                       navController: NavHostController
    ) {
        LazyColumn(
            modifier = modifier
        ) {
            items(list.size) { id ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text(text = list.get(id).cityName)
                    IconButton(onClick = {
                        vm.deleteOneCity(list.get(id))
                    }) {
                        Icon(Icons.Default.Delete,"")
                    }
                }
            }
        }
    }
}
