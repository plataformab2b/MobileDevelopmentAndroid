package com.example.week56test.Views

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.week56test.Models.Product
import com.example.week56test.Models.ProductInterface
import com.example.week56test.ViewModels.ProductViewModel

@Composable
fun ProductList(modifier: Modifier, list: SnapshotStateList<Product>) {
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
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
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