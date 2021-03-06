package com.example.store.navigation

sealed class NavigationScreens(val route:String){
    object  Cart : NavigationScreens(route = "cart")
    object  CheckOut : NavigationScreens(route = "checkout")
    object  Home : NavigationScreens(route = "home")
}
