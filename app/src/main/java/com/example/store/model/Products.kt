package com.example.store.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Products(
    val category: String?=null,
    val description: String?=null,
    val id: Int?=null,
    val image: String?=null,
    val price: String?=null,
    val title: String?=null
):Serializable