package com.example.marketplace.domain.modules

import com.example.marketplace.domain.Repository
import com.example.marketplace.domain.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun newsRepo(impl: RepositoryImpl): Repository
}