package com.example.shoppinglist.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.shoppinglist.repository.ShoppingRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyTestService : Service(), LifecycleOwner {

    @Inject
    lateinit var shoppingRepository: ShoppingRepository

    override fun onCreate() {
        super.onCreate()

        shoppingRepository.getShoppingItems().observe(this, Observer {
            println(it[0].toString())
        })
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycle
    }
}