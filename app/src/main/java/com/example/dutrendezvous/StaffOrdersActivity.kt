package com.example.dutrendezvous

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StaffOrdersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)

        val tvFilterAll = findViewById<TextView>(R.id.tvFilterAll)
        val tvFilterPending = findViewById<TextView>(R.id.tvFilterPending)
        val tvFilterCompleted = findViewById<TextView>(R.id.tvFilterCompleted)

        tvFilterAll.setOnClickListener {
            Toast.makeText(this, "Showing All Orders", Toast.LENGTH_SHORT).show()
            // Logic to show all items
        }

        tvFilterPending.setOnClickListener {
            Toast.makeText(this, "Showing Pending Orders", Toast.LENGTH_SHORT).show()
            // Logic to filter pending items
        }

        tvFilterCompleted.setOnClickListener {
            Toast.makeText(this, "Showing Completed Orders", Toast.LENGTH_SHORT).show()
            // Logic to filter completed items
        }
    }
}