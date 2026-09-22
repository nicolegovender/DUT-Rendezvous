package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_confirmation) // Make sure this matches your XML filename

        // 1. Initialize Views (Change R.id.xxx if your XML uses different names)
        val tvOrderId = findViewById<TextView>(R.id.tvOrderId)
        val tvPickupTime = findViewById<TextView>(R.id.tvPickupTime)
        val btnViewOrders = findViewById<Button>(R.id.btnViewOrders)
        val tvBackHome = findViewById<TextView>(R.id.tvBackHome)

        // 2. Set Dynamic Data (In a real app, you would pass this from the checkout screen)
        //tvOrderId.text = "Order ID: #ORD1025"
        //tvPickupTime.text = "Pickup Time: 24 May 2025, 14:30"

        // 3. Button Clicks
        btnViewOrders.setOnClickListener {
            // Navigate to your Orders History screen
            // val intent = Intent(this, OrdersHistoryActivity::class.java)
            // startActivity(intent)
        }

        tvBackHome.setOnClickListener {
            // Go back to the Home Screen and clear the back stack
            val intent = Intent(this, MainActivity::class.java) // Assuming MainActivity is Home
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}