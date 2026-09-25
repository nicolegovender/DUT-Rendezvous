package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminDashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        // Top Grid Cards
        val cardTodaysOrders = findViewById<LinearLayout>(R.id.cardTodaysOrders)
        val cardTodaysReservations = findViewById<LinearLayout>(R.id.cardTodaysReservations)
        val cardMenuItems = findViewById<LinearLayout>(R.id.cardMenuItems)
        val cardLowStock = findViewById<LinearLayout>(R.id.cardLowStock)

        // Bottom Menu Items
        val tvMenuOrders = findViewById<TextView>(R.id.tvMenuOrders)
        val tvMenuReservations = findViewById<TextView>(R.id.tvMenuReservations)
        val tvMenuLogout = findViewById<TextView>(R.id.tvMenuLogout)

        // Today's Orders
        cardTodaysOrders.setOnClickListener {
            startActivity(Intent(this, StaffOrdersActivity::class.java))
        }

        // Today's Reservations
        cardTodaysReservations.setOnClickListener {
            startActivity(Intent(this, StaffReservationsActivity::class.java))
        }

        // Menu Items
        cardMenuItems.setOnClickListener {
            Toast.makeText(this, "Menu Items clicked", Toast.LENGTH_SHORT).show()
        }

        // Low Stock Items
        cardLowStock.setOnClickListener {
            startActivity(Intent(this, LowInventoryActivity::class.java))
        }

        // Bottom Menu - Orders
        tvMenuOrders.setOnClickListener {
            startActivity(Intent(this, StaffOrdersActivity::class.java))
        }

        // Bottom Menu - Reservations
        tvMenuReservations.setOnClickListener {
            startActivity(Intent(this, StaffReservationsActivity::class.java))
        }

        // Logout
        tvMenuLogout.setOnClickListener {
            val intent = Intent(this, StaffLoginActivity::class.java)
            intent.flags =
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP

            startActivity(intent)
            finish()
        }
    }
}