package com.example.week56test

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.week56test.Models.Product
import com.example.week56test.Models.ProductRepository
import com.example.week56test.ViewModels.ProductViewModel
import com.example.week56test.ViewModels.ProductViewModelFactory
import com.example.week56test.Views.ProductList
import com.example.week56test.ui.theme.Week56testTheme

class MainActivity : ComponentActivity() {
    lateinit var plist: ArrayList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var productRepo = ProductRepository()
        // factory
        var productVMFactory = ProductViewModelFactory(productRepo)

        val productViewModel = ViewModelProvider(this,productVMFactory) [ProductViewModel::class.java]
        plist = productViewModel.getProducts()

        enableEdgeToEdge()
        setContent {
            Week56testTheme {
                var cnx = LocalContext.current
                updateUI(cnx,plist)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun updateUI(con: Context, list: ArrayList<Product>){
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(title = { Text("Products") }) },
            content = { innerPadding ->
                ProductList(
                    modifier =  Modifier.fillMaxSize().padding(innerPadding),
                    list = list
                )
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    var intent = Intent(con, AddNewProduct::class.java)
                    intent.putParcelableArrayListExtra("list",ArrayList(plist))
                    startActivity(intent)
                } ) {
                    Icon(Icons.Default.Add, contentDescription = "Add New Product")
                }
            }
        )
    }

}



