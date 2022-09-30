package com.example.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.databinding.ItemShoppingBinding
import com.example.shoppinglist.model.ShoppingItem
import com.example.shoppinglist.viewmodels.ShoppingViewModel
import kotlinx.android.extensions.LayoutContainer

class ShoppingAdapter(var items: List<ShoppingItem>, val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
//      val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shopping, parent, false)
        val binding =
            ItemShoppingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(private val binding: ItemShoppingBinding) :
        RecyclerView.ViewHolder(binding.root), LayoutContainer {

        override val containerView: View?
            get() = binding.root.rootView

        fun bind(item: ShoppingItem) {
            binding.apply {
                tvName.text = item.name
                tvCount.text = "${item.count}"

                ivDelete.setOnClickListener {
                    viewModel.deleteShoppingItem(item)
                }

                ivPlus.setOnClickListener {
                    item.count++
                    viewModel.upsertShoppingItem(item)
                }

                ivMinus.setOnClickListener {
                    if (item.count > 0) {
                        item.count--
                        viewModel.upsertShoppingItem(item)
                    }
                }
            }
        }
    }
}

