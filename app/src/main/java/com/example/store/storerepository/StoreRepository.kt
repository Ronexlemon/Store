package com.example.store.storerepository

import com.example.store.api.StoreService
import javax.inject.Inject

class StoreRepository
@Inject constructor(private val dao:StoreService){
    suspend fun getAllProducts() = dao.getAllProducts()
    suspend fun  getAllJewery() = dao.getAllProductsJewelery()
    suspend fun  getAllElectronics() = dao.getAllProductsElectronic()
}