package com.example.marketplace.domain

import com.example.marketplace.data.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface UseCase {
    suspend fun insert(products: List<ProductEntity>)
    suspend fun products(): Flow<List<ProductEntity>>
    suspend fun getByID(productID: Int): ProductEntity?
}