package com.example.week4project.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.week4project.Views.CallScreen
import com.example.week4project.Views.EmailScreen
import com.example.week4project.Views.FavoriteScreen
import com.example.week4project.Views.SearchScreen
import com.example.week9_navigation.Navigation.NavItem


@Composable
fun MyNavGraph(navController: NavHostController){
    NavHost(navController = navController,
        startDestination = NavItem.Call.path) {

        composable(
            route = NavItem.Call.path
        ) {
            CallScreen()
        }

        composable(
            route = NavItem.Email.path
        ) {
            EmailScreen()
        }

        composable(
            route = NavItem.Favorite.path
        ) {
            FavoriteScreen()
        }

        composable(
            route = NavItem.Search.path
        ) {
            SearchScreen()
        }
    }
}
