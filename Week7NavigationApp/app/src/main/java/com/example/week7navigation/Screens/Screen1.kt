package com.example.week7navigation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.week7navigation.Navigation.NavDestinations

@Composable
fun Screen1(navController: NavController, year: String?){

    var value by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Screen 1 ")

        year?.let {
            Text("Year From Screen 2 $year")
        }
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Value to screen 2") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            navController.navigate(NavDestinations.Screen2.createRoute(value))// Screen2/value

        }) { Text("Go to Screen 2") }
    }

}