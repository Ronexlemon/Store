package com.example.store.appconstants

import androidx.compose.ui.graphics.Color

object AppConstants {
    const val BaseUrl ="https://fakestoreapi.com"
    const val DataBaseName ="ProductStore"
    const val TableName="Products"
    const val EndPoint ="/products"
    const val EndPointJewelery ="/products/category/jewelery"
    const val EndPointElectronic="/products/category/electronics"
    const val EndPointMenCloths="/products/category/men's clothing"
    const val EndPointWomenCloths="/products/category/women's clothing"
    //const val EndPointcart = "/carts"
    val  colors = listOf(

        Color(0xFFDBB3B1),
        Color(0xFFC89FA3),
        Color(0xFFA67F8E),
        Color(0xFF6C534E),
        Color(0xFF2C1A1D),



    )
    val checkoutcolor =  Color(0xFFDBB3B1)
    val  colorsScrool = listOf(
        Color(0xFFEEEAFE),
        Color(0xFFAB89FF),
        Color(0xFF1C98B4)
    )
     val  colorbackground=  listOf(
        Color(0xFFA67F8E),
         Color(0xFFA67F8E)

    )
}