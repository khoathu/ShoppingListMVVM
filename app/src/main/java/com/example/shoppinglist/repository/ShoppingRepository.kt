package com.example.shoppinglist.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglist.model.ShoppingItem

interface ShoppingRepository {
    suspend fun upsertShoppingItem(item: ShoppingItem): Long

    suspend fun deleteShoppingItem(item: ShoppingItem)

    fun getShoppingItems(): LiveData<List<ShoppingItem>>
}