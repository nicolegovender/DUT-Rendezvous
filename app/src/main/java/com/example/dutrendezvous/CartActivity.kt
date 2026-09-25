package com.example.dutrendezvous

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class CartActivity : ComponentActivity() {

    private lateinit var listViewCartItems: ListView
    private lateinit var textViewTotal: TextView
    private lateinit var buttonCheckout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cart)

        listViewCartItems = findViewById(R.id.listViewCartItems)
        textViewTotal = findViewById(R.id.tvCartTotal)
        buttonCheckout = findViewById(R.id.btnCartCheckout)

        val cartItems = arrayOf(
            "Item 1",
            "Item 2",
            "Item 3"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            cartItems
        )

        listViewCartItems.adapter = adapter

        textViewTotal.text = "TOTAL: R0.00"

        buttonCheckout.setOnClickListener {
            Toast.makeText(
                this,
                "Proceeding to checkout...",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}