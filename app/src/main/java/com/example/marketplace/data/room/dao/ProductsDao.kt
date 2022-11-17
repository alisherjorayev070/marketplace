package com.example.marketplace.data.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.marketplace.data.room.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDao {

    @Insert
    suspend fun insert(products: List<ProductEntity>)

    @Delete
    suspend fun delete(productEntity: ProductEntity)

    @Query("SELECT * FROM products WHERE productId=:productID")
    suspend fun getByID(productID: Int): ProductEntity?

    @Query("SELECT * FROM products")
    fun products(): Flow<List<ProductEntity>>

//    @Query("SELECT * FROM products WHERE title LIKE '%'|| :search ||'%'")
//    fun searchBookmark(search: String): Flow<List<ProductEntity>>
}