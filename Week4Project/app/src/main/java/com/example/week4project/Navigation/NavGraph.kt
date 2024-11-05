package com.example.week4project.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.week4project.Views.CallScreen
import com.example.week4project.Views.EmailScreen
import com.example.week4project.Views.FavoriteScreen
import com.example.week4project.Views.SearchScreen

@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController,
        startDestination = NavDesination.Search.path){

       composable(NavDesination.Search.path){
           SearchScreen()
       }
        composable(NavDesination.Call.path){
            CallScreen()
        }
        composable(NavDesination.Favorite.path){
            FavoriteScreen()
        }
        composable(NavDesination.Email.path){
            EmailScreen()
        }

    }


}