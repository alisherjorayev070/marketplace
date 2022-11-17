package com.example.marketplace.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    var name: String,
    var price: String,
    var description: String,
    var imageID: Int
)
