package com.example.week56test

import android.os.Bundle
import android.util.Log

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.week56test.Models.ProductRepository
import com.example.week56test.ViewModels.ProductViewModel
import com.example.week56test.ViewModels.ProductViewModelFactory
import com.example.week56test.Views.AddNewProductView
import com.example.week56test.ui.theme.Week56testTheme

class AddNewProduct : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //var mainlist = intent.getParcelableArrayListExtra<Product>("list")

        var productRepo = ProductRepository()
        // factory
        var productVMFactory = ProductViewModelFactory(productRepo)
        // view model
       // val productViewModel = ViewModelProvider(this,productVMFactory)
//        var mainlist =  productViewModel.getProducts() //ProductRepository().getProducts()

        enableEdgeToEdge()
        setContent {
            Week56testTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(title = { Text("Add New Product") }) },
                    content = { innerPadding ->
                            AddNewProductView(
                                modifier =  Modifier.fillMaxSize().padding(innerPadding),
                                done = { p->
                                   // productViewModel.addNewProduct(p)
                                    finish()
                                }
                            )

                    }

                )
            }
        }
    }
}



