package com.example.dutrendezvous

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import java.util.Calendar

class ReservationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_customer_reservation)

        val txtDate =
            findViewById<EditText>(R.id.txtDate)

        val btnReserve =
            findViewById<Button>(R.id.btnReserveTable)

        txtDate.setOnClickListener {

            val calendar = Calendar.getInstance()

            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->

                    txtDate.setText(
                        "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    )
                },
                year,
                month,
                day
            ).show()
        }

        btnReserve.setOnClickListener {

            ReservationManager.fullName =
                findViewById<EditText>(R.id.txtReserveFullName)
                    .text.toString()

            ReservationManager.date =
                findViewById<EditText>(R.id.txtDate)
                    .text.toString()

            ReservationManager.time =
                findViewById<EditText>(R.id.txtTime)
                    .text.toString()

            ReservationManager.guests =
                findViewById<EditText>(R.id.txtNumOfGuests)
                    .text.toString()

            ReservationManager.requests =
                findViewById<EditText>(R.id.txtRequests)
                    .text.toString()

            startActivity(
                Intent(
                    this,
                    ReservationConfirmationActivity::class.java
                )
            )
        }
    }
}