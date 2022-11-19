package com.example.marketplace.data.room.entity

data class ProductEntity(
    val productId: Int,
    val name: String,
    val price: String,
    val description: String,
    val imageID: Int,
    var aboutProduct: List<AboutProductItemData>
)
