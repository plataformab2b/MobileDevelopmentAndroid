package com.example.week4project.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search


sealed class NavDesination {

    object Search : Item("search","Search", Icons.Default.Search)
    object Call : Item("call","Call", Icons.Default.Call)
    object Favorite : Item("favorite","Favorite", Icons.Default.Favorite)
    object Email : Item("email","Email", Icons.Default.Email)


}