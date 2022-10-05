package com.example.shoppinglist.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.repository.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val shoppingRepositoryInterface: ShoppingRepository
) : ViewModel() {

    fun upsertShoppingItem(item: ShoppingItem) = viewModelScope.launch {
        shoppingRepositoryInterface.upsertShoppingItem(item)
    }

    fun deleteShoppingItem(item: ShoppingItem) = viewModelScope.launch {
        shoppingRepositoryInterface.deleteShoppingItem(item)
    }

    fun getShoppingItems() = shoppingRepositoryInterface.getShoppingItems()
}