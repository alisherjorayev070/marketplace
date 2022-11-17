package com.example.marketplace.domain.modules

import android.content.Context
import androidx.room.Room
import com.example.marketplace.data.room.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideLocalDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java, "local.db")
            .build()

    @Provides
    @Singleton
    fun provideProductsDao(appDatabase: AppDatabase) = appDatabase.productsDao()
}