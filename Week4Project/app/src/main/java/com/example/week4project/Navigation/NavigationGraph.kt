//package com.example.week9_navigation.Navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.NavType
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.navArgument
//import com.example.week4project.Views.CallScreen
//
//@Composable
//fun NavigationGraph(navController: NavHostController){
//NavHost(
//navController = navController,
//startDestination = NavItem.Search.path
//) {
//    composable(
//        route = NavItem.Search.path
//    ){
//
//    }
//    composable(
//        route = NavItem.Call.path
//    )
//    {
//        CallScreen()
//
//
//    }
//
//    composable(
//        route = NavItem.Favorite.path
//    ){
//
//    }
//    composable(
//        route = NavItem.Email.path
//    ){
//
//    }
//}
//}