package com.example.shoppinglist.di

import com.example.shoppinglist.repository.ShoppingRepository
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val repositoryModule = DI.Module(name = "repository_module")
{
    bind<ShoppingRepository>() with singleton {
        ShoppingRepository(instance())
    }
}