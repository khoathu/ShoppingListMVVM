package com.example.shoppinglist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.repository.ShoppingRepository
import com.example.shoppinglist.viewmodels.ShoppingViewModel

@Suppress("UNCHECKED_CAST")
class ShoppingViewModelFactory(
    private val shoppingRepository: ShoppingRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(shoppingRepository) as T
    }
}