package com.example.week56test.Views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import  androidx.compose.material3.*;
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.week56test.Models.Product

@Composable
fun AddNewProductView(
    modifier: Modifier,
    done: (Product) -> Unit
) {

    var productID = remember { mutableStateOf("") }
    var productName = remember { mutableStateOf("") }
    var productQuantity = remember { mutableStateOf("") }
    var productPrice = remember { mutableStateOf("") }
        Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = productID.value,
                label = { Text("Enter Product's ID") },
                onValueChange = {productID.value = it}
            )
           TextField(
                value = productName.value,
                label = { Text("Enter Product's Name") },
                onValueChange = {productName.value = it}
            )
            TextField(
                value = productQuantity.value,
                label = { Text("Enter Product's Quantity") },
                onValueChange = {productQuantity.value = it}
            )
            TextField(
                value = productPrice.value,
                label = { Text("Enter Product's Price") },
                onValueChange = {productPrice.value = it}
            )
            Button(onClick = {
                var p = Product(productID.value.toInt(),
                    productName.value,
                    productQuantity.value.toInt(),
                    productPrice.value.toDouble())
                    done(p)

            }) {
                Text("Add New Product")
            }
        }

}

