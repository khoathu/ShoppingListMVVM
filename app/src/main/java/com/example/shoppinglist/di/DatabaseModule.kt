package com.example.shoppinglist.di

import android.app.Application
import androidx.room.Room
import com.example.shoppinglist.data.ShoppingDao
import com.example.shoppinglist.data.ShoppingDatabase
import com.example.shoppinglist.data.repository.ShoppingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideShoppingDatabase(appContext: Application): ShoppingDatabase {
        return Room.databaseBuilder(
            appContext,
            ShoppingDatabase::class.java,
            "shopping_db.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideShoppingDao(db: ShoppingDatabase): ShoppingDao {
        return db.getShoppingDao()
    }

    @Provides
    @Singleton
    fun provideShoppingRepository(shoppingDao: ShoppingDao): ShoppingRepositoryImpl {
        return ShoppingRepositoryImpl(shoppingDao)
    }
}