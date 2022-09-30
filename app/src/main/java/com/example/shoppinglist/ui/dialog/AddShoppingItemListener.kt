package com.example.shoppinglist.ui.dialog

import com.example.shoppinglist.model.ShoppingItem

interface AddShoppingItemListener {
    fun onAddShoppingItemClick(item: ShoppingItem)
}