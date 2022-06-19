package com.example.store.room.storedatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.store.room.ProductRoom
import com.example.store.room.StoreDao


@Database(entities = [ProductRoom::class], version = 1)
 abstract  class StoreDatabase : RoomDatabase()  {
     abstract  fun getDao():StoreDao
}