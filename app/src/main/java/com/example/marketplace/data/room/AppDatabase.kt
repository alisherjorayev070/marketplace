package com.example.marketplace.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marketplace.data.room.dao.ProductsDao
import com.example.marketplace.data.room.entity.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao
}