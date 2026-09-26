package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import android.widget.Button

class HomepageActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_homepage)

        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnTakeaway = findViewById<Button>(R.id.btnTakeaway)
        val btnReservation = findViewById<Button>(R.id.btnReservation)
        val btnCart = findViewById<Button>(R.id.btnCart)

        btnMenu.setOnClickListener {
            startActivity(
                Intent(this, MenuActivity::class.java)
            )
        }

        btnTakeaway.setOnClickListener {
            startActivity(
                Intent(this, TakeawayActivity::class.java)
            )
        }

        btnReservation.setOnClickListener {
            startActivity(
                Intent(this, ReservationActivity::class.java)
            )
        }

        btnCart.setOnClickListener {
            startActivity(
                Intent(this, CartActivity::class.java)
            )
        }
    }
}