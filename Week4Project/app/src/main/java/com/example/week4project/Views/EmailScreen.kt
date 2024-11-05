package com.example.week4project.Views

import androidx.compose.runtime.Composable
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun EmailScreen(){
    var cnx = LocalContext.current
    var fromaddress by remember { mutableStateOf("") }
    var bccEmailAddress by remember { mutableStateOf("") }
    var ccEmail by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            value = fromaddress,
            onValueChange = { fromaddress = it },
            label = { Text("From Email Address") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = bccEmailAddress,
            onValueChange = { bccEmailAddress = it },
            label = { Text("BCC Email Address") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = ccEmail,
            onValueChange = { ccEmail = it },
            label = { Text("CC Email Address") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = subject,
            onValueChange = { subject = it },
            label = { Text("Subject") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, fromaddress)
                putExtra(Intent.EXTRA_BCC, bccEmailAddress)
                putExtra(Intent.EXTRA_CC, ccEmail)
                putExtra(Intent.EXTRA_SUBJECT, subject)
            }
            cnx.startActivity(intent)
        }) {
            Text("Send")
        }
    }
}