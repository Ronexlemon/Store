package com.example.store.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.store.Screen.MainDetailScreen
import com.example.store.model.Products

@Composable
fun DetailNavigationGraph(navHostController: NavHostController,data:Products,scaffoldState: ScaffoldState){
    NavHost(navController =navHostController , startDestination = NavigationScreens.Cart.route ){
        composable(route = NavigationScreens.Cart.route){
            MainDetailScreen(data =data , scaffoldState =scaffoldState )
        }
    }
}