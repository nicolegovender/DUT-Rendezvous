package com.example.dutrendezvous

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StaffReservationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        // Find the filter tabs
        val tvFilterAll = findViewById<TextView>(R.id.tvResFilterAll)
        val tvFilterToday = findViewById<TextView>(R.id.tvResFilterToday)
        val tvFilterUpcoming = findViewById<TextView>(R.id.tvResFilterUpcoming)

        // Set up click listeners
        tvFilterAll.setOnClickListener {
            Toast.makeText(this, "Showing All Reservations", Toast.LENGTH_SHORT).show()
            // Later, add code to filter the list
        }

        tvFilterToday.setOnClickListener {
            Toast.makeText(this, "Showing Today's Reservations", Toast.LENGTH_SHORT).show()
            // Later, add code to filter the list
        }

        tvFilterUpcoming.setOnClickListener {
            Toast.makeText(this, "Showing Upcoming Reservations", Toast.LENGTH_SHORT).show()
            // Later, add code to filter the list
        }
    }
}