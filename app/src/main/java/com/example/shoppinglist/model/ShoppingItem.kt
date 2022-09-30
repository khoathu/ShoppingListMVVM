package com.example.shoppinglist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name: String,
    var count: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
