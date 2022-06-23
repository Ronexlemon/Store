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
        Color(0xFFFFC107),
        Color(0xFFFF9800),
        Color(0xFFFF5722)
    )
}