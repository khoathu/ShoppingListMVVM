package com.example.shoppinglist.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.model.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem): Long

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}