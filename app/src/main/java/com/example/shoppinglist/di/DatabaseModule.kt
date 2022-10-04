package com.example.shoppinglist.di

import android.content.Context
import androidx.room.Room
import com.example.shoppinglist.db.ShoppingDao
import com.example.shoppinglist.db.ShoppingDatabase
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.singleton

val databaseModule = DI.Module(name = "database_module")
{
    bind<ShoppingDatabase>() with singleton {
        getShoppingDatabase(instance())
    }
    bind<ShoppingDao>() with singleton { instance<ShoppingDatabase>().getShoppingDao() }
}

fun getShoppingDatabase(context: Context): ShoppingDatabase {
    return Room.databaseBuilder(
        context,
        ShoppingDatabase::class.java,
        "shopping_db.db"
    ).build()
}