package com.example.store.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoreDao {
    @Query("Select * from products")
    fun getall():LiveData<List<ProductRoom>>
    @Insert()
    suspend fun insert(product:ProductRoom)
    @Delete
    suspend fun delete(product: ProductRoom)

}