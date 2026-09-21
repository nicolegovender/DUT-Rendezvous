package com.example.dutrendezvous

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReservationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This links to your reservation XML layout
        setContentView(R.layout.activity_reservation)

        // 1. Find all the text fields and the button using their IDs from the XML
        val etFullName = findViewById<EditText>(R.id.txtReserveFullName)
        val etDate = findViewById<EditText>(R.id.txtDate)
        val etTime = findViewById<EditText>(R.id.txtTime)
        val etGuests = findViewById<EditText>(R.id.txtNumOfGuests)
        val etRequests = findViewById<EditText>(R.id.txtRequests)
        val btnReserve = findViewById<Button>(R.id.btnReserveTable)

        // 2. Set the click listener for the Reserve button
        btnReserve.setOnClickListener {
            // Grab the text from all the input fields
            val fullName = etFullName.text.toString()
            val date = etDate.text.toString()
            val time = etTime.text.toString()
            val guests = etGuests.text.toString()
            val requests = etRequests.text.toString()

            // --- Check if required fields are empty ---
            if (fullName.isEmpty() || date.isEmpty() || time.isEmpty() || guests.isEmpty()) {
                Toast.makeText(this, "Please fill in all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Stop here if fields are empty
            }

            // --- SAVE THE DATA ---
            // For now, we just display the saved data in a popup message
            val summary = "Reservation for $fullName on $date at $time for $guests guests."
            Toast.makeText(this, summary, Toast.LENGTH_LONG).show()

            // You can also use the 'requests' variable like this if you want it in the message:
            // val summaryWithRequests = "$summary Requests: $requests"
        }
    }
}