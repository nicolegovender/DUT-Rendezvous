package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.ComponentActivity

class ReservationConfirmationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_reservation_confirmation)

        val btnViewReservations =
            findViewById<Button>(R.id.btnViewReservations)

        val btnBackHome =
            findViewById<LinearLayout>(R.id.btnBackHomeRes)

        btnViewReservations.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MyReservationsActivity::class.java
                )
            )
        }

        btnBackHome.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    HomepageActivity::class.java
                )
            )
        }
    }
}