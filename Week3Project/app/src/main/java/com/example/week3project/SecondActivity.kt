package com.example.week3project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

class SecondActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val i = intent.getIntExtra("counter", 0)
            val name : String = intent.getStringExtra("user name").toString()
            myFirstTable(name)

        }
    }

}

@Composable
fun myFirstTable(n: String){
    val pResource = painterResource(R.drawable.pic)
    val names = listOf("Mary", "John", "Lee","Mary")
    Column (modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text("Hello $n")
        LazyColumn {
           items(names){
               Row {
                   Text("User Name $it")
                   Image(pResource, "image in the row")
               }
           }

        }
        Button(onClick = {

        }) { Text("Back") }
    }

}


