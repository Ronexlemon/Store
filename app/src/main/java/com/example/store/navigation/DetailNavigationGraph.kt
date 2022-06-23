package com.example.store.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.store.Screen.CheckOutScreen
import com.example.store.Screen.MainDetailScreen
import com.example.store.model.Products
import kotlinx.coroutines.CoroutineScope

@Composable
fun DetailNavigationGraph(navHostController: NavHostController,data:Products,scaffoldState: ScaffoldState,scope: CoroutineScope){
    NavHost(navController =navHostController , startDestination = NavigationScreens.Cart.route ){
        composable(route = NavigationScreens.Cart.route){
            MainDetailScreen(data =data , scaffoldState =scaffoldState, scope = scope, navHostController = navHostController )
        }
        composable(route = "${NavigationScreens.CheckOut.route}/{price}",

            arguments = listOf(
                navArgument("price"){type = NavType.StringType }
       )){
CheckOutScreen(it.arguments?.getString("price"))
        }
    }
}