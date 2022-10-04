package com.example.shoppinglist

import android.app.Application
import android.content.Context
import com.example.shoppinglist.db.ShoppingDatabase
import com.example.shoppinglist.repository.ShoppingRepository
import com.example.shoppinglist.ui.ShoppingViewModelFactory
import org.kodein.di.*


class MyApplication : Application(), DIAware {
    override val di: DI = DI.lazy {
        bind<Context>() with singleton { applicationContext }
        bind<ShoppingDatabase>() with singleton { ShoppingDatabase(instance()) }
        bind<ShoppingRepository>() with singleton { ShoppingRepository(instance()) }
        //bind() from provider { ShoppingViewModelFactory(instance()) }
        bind<ShoppingViewModelFactory>() with provider { ShoppingViewModelFactory(instance()) }
    }

}