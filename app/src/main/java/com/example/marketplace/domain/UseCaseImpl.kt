package com.example.marketplace.domain

import com.example.marketplace.data.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UseCaseImpl @Inject constructor(
    private val repository: Repository
) : UseCase {

    override suspend fun products(): Flow<List<ProductEntity>> {
        return repository.products()
    }

    override suspend fun getByID(productID: Int): ProductEntity? {
        return repository.getByID(productID)
    }

    override suspend fun insert(products: List<ProductEntity>) {
        return repository.insert(products)
    }

}