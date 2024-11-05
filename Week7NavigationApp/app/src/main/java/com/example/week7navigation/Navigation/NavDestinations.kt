package com.example.week7navigation.Navigation

sealed class NavDestinations(var route: String) {

    object Screen1 : NavDestinations("Screen1")

    object Screen2 : NavDestinations("Screen2"){// Screen2 ===> Screen2/{value}

        fun createRoute(valueToPass: String): String {
            return "Screen2/$valueToPass"
        }
    }

}