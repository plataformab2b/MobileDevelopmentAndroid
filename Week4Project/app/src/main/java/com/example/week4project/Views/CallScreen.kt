package com.example.week4project.Views

import android.content.Intent
import android.net.Uri
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun CallScreen() {
    var cnx = LocalContext.current
    var phoneNumber by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Phone number ") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse(phoneNumber)
            }
            cnx.startActivity(intent)

        }){
            Text("Call")
        }
    }
}