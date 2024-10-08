package com.example.week3project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week3project.ui.theme.Week3ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Counter()
        }
    }
}
@Composable
fun Counter() {
    val context = LocalContext.current
    val pResource = painterResource(R.drawable.pic)
    val counter = remember { mutableStateOf(0) }
    val nameInput = remember { mutableStateOf("") }
Column {
    Column(
        Modifier.fillMaxWidth().fillMaxHeight(0.5f).background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "${counter.value}", fontSize = 30.sp)
        Row {
            Button(colors = ButtonDefaults.buttonColors(Color.Red), onClick = {
                counter.value += 1
                Log.d("counter", "$counter")
            }) {
                Text(text = "++")
            }
            Button(
                colors = ButtonDefaults.buttonColors(Color.Red),
                onClick = {
                    counter.value -= 1
                    Log.d("counter", "$counter")
                }) {
                Text(text = "--")
            }
        }

    }

    Column (
        Modifier.fillMaxWidth().fillMaxHeight(1f).background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {

        Image(painter = pResource, contentDescription = "my image",
            modifier = Modifier.fillMaxWidth())

        TextField(
            label = {Text(text = "First Name")},
            placeholder = { Text("e.g. John") }
            , value = nameInput.value,
            onValueChange = {
            nameInput.value = it
        })

        FloatingActionButton(
            onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                intent.putExtra("counter",counter.value)
                intent.putExtra("user name", nameInput.value)
                context.startActivity(intent)
        }) { Text(text = "Next") }

    }

}
}
