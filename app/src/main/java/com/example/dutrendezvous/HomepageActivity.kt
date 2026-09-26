package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class HomepageActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_homepage)

        val btnMenu = findViewById<Button>(R.id.btnMenu)
        val btnTakeaway = findViewById<Button>(R.id.btnTakeaway)
        val btnReservation = findViewById<Button>(R.id.btnReservation)
        val btnCart = findViewById<Button>(R.id.btnCart)

        val tvViewAccount =
            findViewById<TextView>(R.id.tvViewAccount)

        btnMenu.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MenuActivity::class.java
                )
            )
        }

        btnTakeaway.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    TakeawayActivity::class.java
                )
            )
        }

        btnReservation.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ReservationActivity::class.java
                )
            )
        }

        btnCart.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CartActivity::class.java
                )
            )
        }

        tvViewAccount.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AccountActivity::class.java
                )
            )
        }
    }
}