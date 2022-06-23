package com.example.store.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.store.Screen.MainCartScreen
import com.example.store.Screen.MainScreen
import com.example.store.model.Products
import com.example.store.storviemodel.StoreViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope


@Composable
fun NavigationGraph(navHostController: NavHostController,viewModel: StoreViewModel,scaffoldState: ScaffoldState,scope: CoroutineScope,onItemclick:(Products)->Unit){



    NavHost(navController =navHostController, startDestination = NavigationScreens.Home.route ){
        composable(NavigationScreens.Home.route){

           MainScreen(viemodel =viewModel , scaffoldState =scaffoldState , onItemclick =onItemclick,scope=scope , navHostController = navHostController)
        }
        composable(NavigationScreens.Cart.route){
            MainCartScreen(scafoldstate = scaffoldState, viewModel = viewModel)
        }
    }
}

@Composable
fun CartScreen(scaffoldState: ScaffoldState,viewModel: StoreViewModel) {
    MainCartScreen(scafoldstate =scaffoldState, viewModel =viewModel )
}
