package com.example.week4project

import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.week4project.ui.theme.Week4ProjectTheme

class AddressActivity : ComponentActivity()  {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
        var num = intent.getIntExtra("number",0).toInt()
        Log.d("In Address Activity", ""+num)
        var addressFromMainActivity =  intent.getParcelableExtra<Address>("myaddress")
        setContent {
            Week4ProjectTheme {

              Column (modifier =  Modifier.fillMaxSize(1f)) {
                  Text("street number and name")
                  Text("city")
              }
            }
        }
    }
}