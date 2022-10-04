package com.example.shoppinglist

import android.app.Application
import android.content.Context
import com.example.shoppinglist.di.databaseModule
import com.example.shoppinglist.di.repositoryModule
import com.example.shoppinglist.di.viewModelModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.bind
import org.kodein.di.singleton


class MyApplication : Application(), DIAware {
    override val di: DI = DI.lazy {
        bind<Context>() with singleton { applicationContext }
        bind<MyApplication>() with singleton { this@MyApplication }

        //bind<ShoppingDatabase>() with singleton { ShoppingDatabase(instance()) }
        //bind<ShoppingRepository>() with singleton { ShoppingRepository(instance()) }
        //bind() from provider { ShoppingViewModelFactory(instance()) }
        //bind<ShoppingViewModelFactory>() with provider { ShoppingViewModelFactory(instance()) }

        import(databaseModule)
        import(repositoryModule)
        import(viewModelModule)
    }

}