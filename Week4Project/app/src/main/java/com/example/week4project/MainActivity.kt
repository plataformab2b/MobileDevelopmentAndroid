package com.example.week4project

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week4project.Model.Product
import com.example.week4project.Model.ProductRepo
import com.example.week4project.Navigation.MyNavGraph
import com.example.week4project.ViewModel.ProductViewModel
import com.example.week4project.ViewModel.ProductViewModelFactory
import com.example.week4project.Views.AdressScreen
import com.example.week4project.Views.MyBottomBar
import com.example.week4project.Views.MyFavButton
import com.example.week4project.Views.MyTopBar
import com.example.week4project.ui.theme.Week4ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var prepo = ProductRepo()
        var pfactory = ProductViewModelFactory(prepo)
        var myProductViewModel = ViewModelProvider(this, pfactory)[ProductViewModel::class.java]

        var mainlist =  myProductViewModel.getListOfProducts()
        setContent {
            Week4ProjectTheme {

               MyFirstScaffold(mainlist)
            }
        }
    }

    override fun onResume() {
        super.onResume()

    }
}

@Composable
fun SwitchBackgroundChange(modifier: Modifier) {
    var isSwitched = remember { mutableStateOf(false) }
    val backgroundColor = if (isSwitched.value) Color.Green else Color.White
    Box(
        modifier = modifier.background(backgroundColor).fillMaxSize()
    ) {
        Switch(
            checked = isSwitched.value,
            onCheckedChange = { isSwitched.value = it },
            colors = SwitchDefaults.colors(checkedThumbColor = Color.White)
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyFirstScaffold(list: ArrayList<Product>) {
    val navController = rememberNavController()
   Scaffold (
       bottomBar = { MyBottomBar(navController) },
       topBar = { MyTopBar() },
       floatingActionButton = { MyFavButton() },
       floatingActionButtonPosition = FabPosition.Center
       ) {

        innerPadding ->
            Column {
                MyNavGraph(navController = navController)
            //  SwitchBackgroundChange(Modifier.padding(innerPadding))
               // ProductList(Modifier.padding(innerPadding), list)
            }
        }
}


@Composable
fun SecondScreen() {
    Column (modifier =  Modifier.fillMaxSize(1f)) {
        Text("Second")

    }
}