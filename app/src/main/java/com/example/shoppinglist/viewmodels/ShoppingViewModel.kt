package com.example.shoppinglist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val shoppingRepository: ShoppingRepository
) : ViewModel() {

    fun upsertShoppingItem(item: ShoppingItem) = viewModelScope.launch {
        shoppingRepository.upsertShoppingItem(item)
    }

    fun deleteShoppingItem(item: ShoppingItem) = viewModelScope.launch {
        shoppingRepository.deleteShoppingItem(item)
    }

    fun getShoppingItems() = shoppingRepository.getShoppingItems()
}