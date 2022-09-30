package com.example.shoppinglist.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.databinding.DialogAddItemShoppingBinding
import com.example.shoppinglist.model.ShoppingItem

class AddShoppingItemDialog(context: Context, private val listener: AddShoppingItemListener) :
    AppCompatDialog(context) {

    lateinit var binding: DialogAddItemShoppingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogAddItemShoppingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            etName.requestFocus()
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
            etCount.setOnEditorActionListener { textView, actionId, keyEvent ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    AddItemAction()
                    return@setOnEditorActionListener true
                }
                false
            }
            tvAdd.setOnClickListener {
                AddItemAction()
            }
            tvCancel.setOnClickListener {
                this@AddShoppingItemDialog.cancel()
                dismiss()
            }
        }
    }

    private fun DialogAddItemShoppingBinding.AddItemAction() {
        val name = etName.text.toString()
        val count = etCount.text.toString()
        if (name.isEmpty() || count.isEmpty()) {
            Toast.makeText(context, "Please input information", Toast.LENGTH_LONG).show()
            return
        }
        val item = ShoppingItem(name, count.toInt())
        listener?.onAddShoppingItemClick(item)
        dismiss()
    }
}