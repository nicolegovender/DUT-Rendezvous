package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class ConfirmationOrderActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_order_confirmation)

        val btnViewOrders =
            findViewById<Button>(R.id.btnViewOrders)

        val btnHome =
            findViewById<Button>(R.id.btnHome)

        btnViewOrders.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MyOrdersActivity::class.java
                )
            )
        }

        btnHome.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    HomepageActivity::class.java
                )
            )
        }
    }
}