package com.example.weatherapp_mvvm_retrofit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.weatherapp_mvvm_retrofit.ui.theme.WeatherAppMVVMRetrofitTheme
import com.example.weatherapp_mvvm_retrofit.viewModel.citiesViewModel
import com.example.weatherapp_mvvm_retrofit.Views.TopBar
import com.example.weatherapp_mvvm_retrofit.viewModel.WeatherViewModel

class MainActivity : ComponentActivity() {
    private val myViewModel : citiesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            WeatherAppMVVMRetrofitTheme {
                Scaffold(
                    topBar = { TopBar(myViewModel) },
                ) { innerPadding ->
                        var list = myViewModel.cities
                    ListOfCities(
                            list = list,
                            modifier = Modifier.padding(innerPadding)
                        )
                }

            }
        }
    }
}

@Composable
fun ListOfCities(list: List<String>, modifier: Modifier = Modifier) {
    var selectedIndex by remember {mutableStateOf(-1)}
    var cnx = LocalContext.current

    LazyColumn(
        modifier = modifier
    ) {
        items(list.size) { id ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp).selectable(
                        selected = id == selectedIndex,
                        onClick = {
                            if (selectedIndex != id) {
                                selectedIndex = id
                                Log.d("city", list[id])
                                var intent = Intent(cnx, WeatherActivity::class.java)
                                intent.putExtra("city",list[id])
                               cnx.startActivity(intent)
                            }
                            else selectedIndex = -1
                        }
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = list.get(id))
            }
        }
    }



}