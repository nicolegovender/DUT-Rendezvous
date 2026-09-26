package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class AccountActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_account)

        val btnMyOrders =
            findViewById<Button>(R.id.btnMyOrders)

        val btnMyReservations =
            findViewById<Button>(R.id.btnMyReservations)

        val btnLogout =
            findViewById<Button>(R.id.btnLogout)

        btnMyOrders.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MyOrdersActivity::class.java
                )
            )
        }

        btnMyReservations.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MyReservationsActivity::class.java
                )
            )
        }

        btnLogout.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    LoginActivity::class.java
                )
            )

            finish()
        }
    }
}