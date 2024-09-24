package com.example.week4project

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week4project.ui.theme.Week4ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week4ProjectTheme {
                MyFirstScaffold()
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyFirstScaffold() {
   Scaffold (
       bottomBar = {MyBottomBar()},
       topBar = { MyTopBar() },
       floatingActionButton = { MyFavButton() },
       floatingActionButtonPosition = FabPosition.Center
       ) {
       innerPadding ->
            Column {
                Text( "Week 4",  Modifier.padding(innerPadding))

            }
   }
}
