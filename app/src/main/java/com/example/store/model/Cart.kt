package com.example.store.model

data class Cart(
    val date: String,
    val id: Int,
    val products: List<Product>,
    val userId: Int
)