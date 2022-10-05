package com.example.shoppinglist.di

import com.example.shoppinglist.data.repository.ShoppingRepositoryImpl
import com.example.shoppinglist.repository.ShoppingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindShoppingRepository(
        shoppingRepository: ShoppingRepositoryImpl // here the class
    ): ShoppingRepository // here the interface that the class implements
}