package com.example.shoppinglist.di

import android.content.Context
import androidx.room.Room
import com.example.shoppinglist.db.ShoppingDatabase
import com.example.shoppinglist.repository.ShoppingRepository
import com.example.shoppinglist.viewmodels.ShoppingViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        ShoppingViewModel(get())
    }
}

val repositoriesModule = module {
    single { ShoppingRepository(get()) }
}

val databaseModule = module {
    fun provideDatabase(context: Context): ShoppingDatabase {
        return Room.databaseBuilder(
            context,
            ShoppingDatabase::class.java,
            "shopping_db.db"
        ).build()
    }

    single { androidContext() }
    single {
        provideDatabase(get())
    }
    single { get<ShoppingDatabase>().getShoppingDao() }
}