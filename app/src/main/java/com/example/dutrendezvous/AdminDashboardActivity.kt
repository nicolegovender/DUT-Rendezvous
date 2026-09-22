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

        // 1. Find the Top Grid Cards
        val cardTodaysOrders = findViewById<LinearLayout>(R.id.cardTodaysOrders)
        val cardTodaysReservations = findViewById<LinearLayout>(R.id.cardTodaysReservations)
        val cardMenuItems = findViewById<LinearLayout>(R.id.cardMenuItems)
        val cardLowStock = findViewById<LinearLayout>(R.id.cardLowStock)

        // 2. Find the Bottom Menu Items
        val tvMenuOrders = findViewById<TextView>(R.id.tvMenuOrders)
        val tvMenuReservations = findViewById<TextView>(R.id.tvMenuReservations)
        val tvMenuLogout = findViewById<TextView>(R.id.tvMenuLogout)

        // 3. Set Click Listeners for the Grid Cards
        cardTodaysOrders.setOnClickListener {
            // Navigate to Staff Orders
            startActivity(Intent(this, StaffOrdersActivity::class.java))
        }

        cardTodaysReservations.setOnClickListener {
            // Navigate to Staff Reservations
            startActivity(Intent(this, StaffReservationsActivity::class.java))
        }

        cardMenuItems.setOnClickListener {
            Toast.makeText(this, "Menu Items clicked", Toast.LENGTH_SHORT).show()
            // Add Intent here later for Menu Items screen
        }

        cardLowStock.setOnClickListener {
            Toast.makeText(this, "Low Stock Items clicked", Toast.LENGTH_SHORT).show()
            // Add Intent here later for Low Stock screen
        }

        // 4. Set Click Listeners for Bottom Menu Items
        tvMenuOrders.setOnClickListener {
            startActivity(Intent(this, StaffOrdersActivity::class.java))
        }

        tvMenuReservations.setOnClickListener {
            startActivity(Intent(this, StaffReservationsActivity::class.java))
        }

        tvMenuLogout.setOnClickListener {
            // Go back to Staff Login and clear the back stack
            val intent = Intent(this, StaffLoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}