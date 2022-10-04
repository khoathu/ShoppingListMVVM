package com.example.shoppinglist.repository

import com.example.shoppinglist.db.ShoppingDatabase
import com.example.shoppinglist.model.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDatabase
) {

    suspend fun upsertShoppingItem(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun deleteShoppingItem(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}