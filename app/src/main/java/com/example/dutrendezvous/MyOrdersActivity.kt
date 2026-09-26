package com.example.dutrendezvous

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MyOrdersActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_orders)

        val tvOrderItems =
            findViewById<TextView>(R.id.tvOrderItems)

        if (CartManager.cartItems.isEmpty()) {

            tvOrderItems.text =
                "No orders placed"

        } else {

            tvOrderItems.text =
                CartManager.cartItems.joinToString("\n")
        }
    }
}