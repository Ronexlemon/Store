package com.example.store.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.store.appconstants.AppConstants.TableName

@Entity(tableName = TableName)
data class ProductRoom(
    @PrimaryKey(autoGenerate = true)
    val id:Int =0,
    @ColumnInfo(name="title")
    val title:String?=null,
    @ColumnInfo(name="price")
val price:Double?=null,
    @ColumnInfo(name="description")
val description:String?=null)
