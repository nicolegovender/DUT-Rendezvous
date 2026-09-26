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

        listViewCartItems =
            findViewById(R.id.listViewCartItems)

        textViewTotal =
            findViewById(R.id.tvCartTotal)

        buttonCheckout =
            findViewById(R.id.btnCartCheckout)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            CartManager.cartItems
        )

        listViewCartItems.adapter = adapter

        textViewTotal.text =
            "Items in Cart: ${CartManager.cartItems.size}"

        buttonCheckout.setOnClickListener {

            startActivity(
                android.content.Intent(
                    this,
                    ConfirmationOrderActivity::class.java
                )
            )
        }
        }
    }
