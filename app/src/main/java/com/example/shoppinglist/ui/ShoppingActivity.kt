package com.example.shoppinglist.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.adapter.ShoppingAdapter
import com.example.shoppinglist.databinding.ActivityShoppingListBinding
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.ui.dialog.AddShoppingItemDialog
import com.example.shoppinglist.ui.dialog.AddShoppingItemListener
import com.example.shoppinglist.viewmodels.ShoppingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoppingActivity : AppCompatActivity() {

    val shoppingViewModel: ShoppingViewModel by viewModel()

    lateinit var binding: ActivityShoppingListBinding
    lateinit var adapter: ShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShoppingListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val repository = ShoppingRepository(ShoppingDatabase(applicationContext))
        val factory = ShoppingViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)
         */

        setupRecycleView()

        shoppingViewModel.getShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fabAdd.setOnClickListener {
            AddShoppingItemDialog(this, object : AddShoppingItemListener {
                override fun onAddShoppingItemClick(item: ShoppingItem) {
                    shoppingViewModel.upsertShoppingItem(item)
                    binding.rvShoppingList.smoothScrollToPosition(adapter.items.size)
                }

            }).show()
        }
        binding.rvShoppingList.setOnClickListener {
            Toast.makeText(this, "Please input information", Toast.LENGTH_LONG).show()
        }

    }

    private fun setupRecycleView() {
        adapter = ShoppingAdapter(listOf(), shoppingViewModel)
        binding.rvShoppingList.apply {
            adapter = this@ShoppingActivity.adapter
            layoutManager = LinearLayoutManager(applicationContext)
        }
    }
}