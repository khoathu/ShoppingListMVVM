package com.example.shoppinglist.di

import com.example.shoppinglist.viewmodels.ShoppingViewModel
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

val viewModelModule = DI.Module(name = "view_model_module")
{
    bindProvider { ShoppingViewModel(instance()) }
}