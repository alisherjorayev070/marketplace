package com.example.marketplace.domain.modules

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {

//    @Provides
//    @Singleton
//    fun provideLocalDB(@ApplicationContext context: Context) =
//        Room.databaseBuilder(context, AppDatabase::class.java, "local.db")
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideProductsDao(appDatabase: AppDatabase) = appDatabase.productsDao()
}