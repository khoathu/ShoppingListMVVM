package com.example.shoppinglist.data.repository

import com.example.shoppinglist.data.ShoppingDao
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.repository.ShoppingRepository
import javax.inject.Inject

class ShoppingRepositoryImpl @Inject constructor(
    val shoppingDao: ShoppingDao
) : ShoppingRepository {

    override suspend fun upsertShoppingItem(item: ShoppingItem) = shoppingDao.upsert(item)

    override suspend fun deleteShoppingItem(item: ShoppingItem) = shoppingDao.delete(item)

    override fun getShoppingItems() = shoppingDao.getAllShoppingItems()
}