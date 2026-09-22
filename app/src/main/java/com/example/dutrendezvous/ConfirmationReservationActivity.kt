package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ConfirmationReservationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_confirmation)

        val tvReservationId = findViewById<TextView>(R.id.tvReservationId)
        val tvReservationDetails = findViewById<TextView>(R.id.tvReservationDetails)
        val btnViewReservations = findViewById<Button>(R.id.btnViewReservations)
        val tvBackHomeRes = findViewById<TextView>(R.id.btnBackHomeRes)

        // Set Mock Data
        //tvReservationId.text = "Reservation ID: #RES2034"
        //tvReservationDetails.text = "Date & Time: 24 May 2025, 19:00\nGuests: 4"

        btnViewReservations.setOnClickListener {
            // Navigate to My Reservations screen
            // val intent = Intent(this, MyReservationsActivity::class.java)
            // startActivity(intent)
        }

        tvBackHomeRes.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}