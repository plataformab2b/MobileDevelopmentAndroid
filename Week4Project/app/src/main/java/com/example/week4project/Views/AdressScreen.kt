package com.example.week4project.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AdressScreen() {
    Column (modifier =  Modifier.fillMaxSize(1f)) {
        Text("street number and name")
        Text("city")
    }
}