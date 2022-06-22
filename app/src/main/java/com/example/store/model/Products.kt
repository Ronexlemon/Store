package com.example.store.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.store.R
import java.io.Serializable

data class Products(
    val category: String?=null,
    val description: String?=null,
    val id: Int?=null,
    val image: String?=null,
    val price: String?=null,
    val title: String?=null
):Serializable
data class AutoScrollingModel(
    @DrawableRes val iconResource: Int,
    val contentDescription: String
)

val autoScrollingList = listOf(
    AutoScrollingModel(R.drawable.shoe2, "Sneaker"),
    AutoScrollingModel(R.drawable.shoe3, "Sneaker"),
    AutoScrollingModel(R.drawable.shoe4, "Nike"),
    AutoScrollingModel(R.drawable.shoe5, "Low Shoes"),
    AutoScrollingModel(R.drawable.short1, "Run Short"),
    AutoScrollingModel(R.drawable.short3, "Khaki Short"),
    AutoScrollingModel(R.drawable.short4, "Jeans Short"),
    AutoScrollingModel(R.drawable.trouser1, "Cago Pants"),
    AutoScrollingModel(R.drawable.trouser2, "Jeans Pants"),
    AutoScrollingModel(R.drawable.trouser3, "Sweat Pants"),
    AutoScrollingModel(R.drawable.tv1, "Samsung"),
    AutoScrollingModel(R.drawable.tv2, "Synix"),
    AutoScrollingModel(R.drawable.tv4, "Sony"),
    AutoScrollingModel(R.drawable.t1, "Black T-Shirt"),
    AutoScrollingModel(R.drawable.t2, "White T-Shirt"),
    AutoScrollingModel(R.drawable.t4, "Red T-Shirt"),
    AutoScrollingModel(R.drawable.t3, "t-shirt"),
    AutoScrollingModel(R.drawable.j1, "Silver"),
    AutoScrollingModel(R.drawable.j2, "Gold"),
    AutoScrollingModel(R.drawable.j3, "Earring"),
    AutoScrollingModel(R.drawable.j4, "Ring"),

)