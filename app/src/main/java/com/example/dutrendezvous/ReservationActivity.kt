package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class ReservationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_customer_reservation
        )

        val btnReserve =
            findViewById<Button>(R.id.btnReserveTable)

        btnReserve.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ReservationConfirmationActivity::class.java
                )
            )
        }
    }
}