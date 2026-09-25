package com.example.dutrendezvous

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity

class ReservationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_reservation)

        val etFullName = findViewById<EditText>(R.id.txtReserveFullName)
        val etDate = findViewById<EditText>(R.id.txtDate)
        val etTime = findViewById<EditText>(R.id.txtTime)
        val etGuests = findViewById<EditText>(R.id.txtNumOfGuests)
        val etRequests = findViewById<EditText>(R.id.txtRequests)
        val btnReserve = findViewById<Button>(R.id.btnReserveTable)

        btnReserve.setOnClickListener {

            val fullName = etFullName.text.toString()
            val date = etDate.text.toString()
            val time = etTime.text.toString()
            val guests = etGuests.text.toString()

            if (
                fullName.isEmpty() ||
                date.isEmpty() ||
                time.isEmpty() ||
                guests.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Please fill in all required fields",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Reservation for $fullName on $date at $time for $guests guests.",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
