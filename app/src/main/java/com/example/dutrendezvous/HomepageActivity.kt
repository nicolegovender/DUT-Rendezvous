package com.example.dutrendezvous

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.ComponentActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button

class HomepageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homepage)

        // --- HOMEPAGE BUTTON NAVIGATION ---

        // 1. Find the Menu button
        val btnMenu = findViewById<Button>(R.id.btnMenu)

        // 2. Set its click listener
        btnMenu.setOnClickListener {
            // Temporary message to test the button
            android.widget.Toast.makeText(
                this,
                "Menu button clicked!",
                android.widget.Toast.LENGTH_SHORT
            ).show()

            // Uncomment these lines AFTER the final merge:
            // val intent = Intent(this, MenuActivity::class.java)
            // startActivity(intent)
        }
        // --- TAKEAWAY BUTTON NAVIGATION ---

        // 1. Find the Takeaway button
        val btnTakeaway = findViewById<Button>(R.id.btnTakeaway)

        // 2. Set its click listener
        btnTakeaway.setOnClickListener {
            // Temporary message to test the button
            android.widget.Toast.makeText(this, "Takeaway button clicked!", android.widget.Toast.LENGTH_SHORT).show()

            // Uncomment these lines AFTER the final merge:
            // val intent = Intent(this, TakeawayActivity::class.java)
            // startActivity(intent)
        }
        // --- RESERVATION BUTTON NAVIGATION ---

        // 1. Find the Reservation button
        val btnReservation = findViewById<Button>(R.id.btnReservation)

        // 2. Set its click listener
        btnReservation.setOnClickListener {
            // Temporary message to test the button
            android.widget.Toast.makeText(this, "Reservation button clicked!", android.widget.Toast.LENGTH_SHORT).show()

            // Uncomment these lines AFTER the final merge:
            // val intent = Intent(this, ReservationActivity::class.java)
            // startActivity(intent)
        }
        // --- VIEW CART BUTTON NAVIGATION ---

        // 1. Find the View Cart button
        val btnCart = findViewById<Button>(R.id.btnCart)

        // 2. Set its click listener
        btnCart.setOnClickListener {
            // Temporary message to test the button
            android.widget.Toast.makeText(this, "View Cart button clicked!", android.widget.Toast.LENGTH_SHORT).show()

            // Uncomment these lines AFTER the final merge:
            // val intent = Intent(this, CartActivity::class.java)
            // startActivity(intent)
        }
    }
    }
