package com.example.store.api

import com.example.store.appconstants.AppConstants.EndPoint
import com.example.store.model.ProductsList
import retrofit2.Response
import retrofit2.http.GET

interface StoreService {
    @GET(EndPoint)
    suspend fun  getAllProducts():Response<ProductsList>

}