package com.example.dutrendezvous

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity

class TakeawayActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_takeaway)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val etQuantity = findViewById<EditText>(R.id.etQuantity)
        val btnAddToOrder = findViewById<Button>(R.id.btnAddToOrder)

        btnAddToOrder.setOnClickListener {

            val selectedItem =
                spinner.selectedItem.toString()

            val quantity =
                etQuantity.text.toString()

            if (quantity.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter a quantity",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val orderItem =
                    "$quantity x $selectedItem"

                CartManager.cartItems.add(orderItem)

                Toast.makeText(
                    this,
                    "$orderItem added to cart",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}