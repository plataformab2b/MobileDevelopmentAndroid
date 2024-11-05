package com.example.week7navigation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.week7navigation.Screens.Screen1
import com.example.week7navigation.Screens.Screen2


@Composable
fun NavGraph(navController: NavHostController){

    NavHost(navController = navController, startDestination = NavDestinations.Screen1.route)
    {
        composable( NavDestinations.Screen1.route) {
            entery ->
            val year = entery.savedStateHandle.get<String>("year")
            Screen1(navController,year)
        }

        composable (NavDestinations.Screen2.route.plus("/{value}"),
            arguments = listOf(navArgument("value"){
                type = NavType.StringType
            })
            )
        {
            backStackEntery ->
                     Screen2(navController, backStackEntery.arguments?.getString("value").toString() )
        }
    }



}