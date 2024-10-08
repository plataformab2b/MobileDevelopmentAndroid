package com.example.week4project.Views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.week4project.Model.Product
import com.example.week4project.Model.ProductRepo
import com.example.week4project.ViewModel.ProductViewModel

@Composable
fun ProductList(modifier: Modifier, list: ArrayList<Product> ) {

    LazyColumn(
        modifier = modifier
    ) {
        items(list) { Product ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Row (modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween){
                    Column {
                        Text(text = "${Product.name}")
                        Text(text = "Quantity: ${Product.quantity}")
                    }

                    Text(text = "Price: ${Product.price}$")
                }

            }
        }
    }
}
