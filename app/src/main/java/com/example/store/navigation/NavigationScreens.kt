package com.example.store.navigation

sealed class NavigationScreens(val route:String){
    object  Cart : NavigationScreens(route = "cart")
    object  Home : NavigationScreens(route = "home")
}
