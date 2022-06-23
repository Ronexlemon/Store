package com.example.store.api

import com.example.store.appconstants.AppConstants.EndPoint
import com.example.store.appconstants.AppConstants.EndPointElectronic
import com.example.store.appconstants.AppConstants.EndPointJewelery
import com.example.store.appconstants.AppConstants.EndPointMenCloths
import com.example.store.appconstants.AppConstants.EndPointWomenCloths

import com.example.store.model.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StoreService {
    @GET(EndPoint)
    suspend fun  getAllProducts(): Response<List<Products>>
    @GET(EndPointJewelery)
    suspend fun  getAllProductsJewelery():Response<List<Products>>
    @GET(EndPointElectronic)
    suspend fun  getAllProductsElectronic():Response<List<Products>>
    @GET(EndPointMenCloths)
    suspend fun  getAllProductsMen():Response<List<Products>>
    @GET(EndPointWomenCloths)
    suspend fun  getAllProductsWomen():Response<List<Products>>
    //get all product from cart


}