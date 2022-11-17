package com.example.marketplace.domain

import com.example.marketplace.data.room.dao.ProductsDao
import com.example.marketplace.data.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val productsDao: ProductsDao
) : Repository {

    override suspend fun products(): Flow<List<ProductEntity>> {
        return productsDao.products()
    }

    override suspend fun getByID(productID: Int): ProductEntity? {
        return productsDao.getByID(productID)
    }

    override suspend fun insert(products: List<ProductEntity>) {
        productsDao.insert(products)
    }

}