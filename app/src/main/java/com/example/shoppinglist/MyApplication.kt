package com.example.shoppinglist

import android.app.Application
import com.example.shoppinglist.di.databaseModule
import com.example.shoppinglist.di.repositoriesModule
import com.example.shoppinglist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                listOf(
                    viewModelModule,
                    repositoriesModule,
                    databaseModule
                )
            ).androidContext(this@MyApplication)
        }
    }
}