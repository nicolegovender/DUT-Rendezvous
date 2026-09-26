package com.example.dutrendezvous

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class MyReservationsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_reservations)

        findViewById<TextView>(R.id.tvResName).text =
            ReservationManager.fullName

        findViewById<TextView>(R.id.tvResDate).text =
            "Date: ${ReservationManager.date}"

        findViewById<TextView>(R.id.tvResTime).text =
            "Time: ${ReservationManager.time}"

        findViewById<TextView>(R.id.tvResGuests).text =
            "Guests: ${ReservationManager.guests}"
    }
}