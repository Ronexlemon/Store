package com.example.store.api

import com.example.store.appconstants.AppConstants.EndPoint
import com.example.store.appconstants.AppConstants.EndPointJewelery
import com.example.store.model.Products
import retrofit2.Response
import retrofit2.http.GET

interface StoreService {
    @GET(EndPoint)
    suspend fun  getAllProducts(): Response<List<Products>>
    @GET(EndPointJewelery)
    suspend fun  getAllProductsJewelery():Response<List<Products>>

}