package com.example.week4project.Views

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.week4project.Model.Address
import com.example.week4project.AddressActivity
import com.example.week4project.Navigation.NavDesination
import com.example.week4project.R

@Composable
fun MyBottomBar(navController: NavController) {

    val navItems = listOf(NavDesination.Call, NavDesination.Email, NavDesination.Search,NavDesination.Favorite)
    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar{
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == index,
                onClick = {
                    navController.navigate(item.path) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                    }
                }, icon = {
                   Icon(imageVector =  item.icon, contentDescription = item.title)
                }, label = {
                   Text( item.title)
                }
            )

        }
    }
}
//
//        Row(modifier = Modifier.fillMaxWidth(1f) ,
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//            ){
//            Text("Search")
//            IconButton(onClick = {
//              // Go to Search
//
//            }) {
//               Icon(painterResource(R.drawable.baseline_local_phone_24), contentDescription = null)
//            }
//
//
//            IconButton(onClick = {
//                   // Go to Fav
//
//            }) {
//                Icon(Icons.Default.Favorite, contentDescription = null)
//            }
//            IconButton(onClick = {
//               // go to email
//
//            }) {
//                Icon(Icons.Default.Email, contentDescription = null)
//            }
//
//
//        }
//    }

