package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create/Open the database
        val databaseHelper = DatabaseHelper(this)
        databaseHelper.writableDatabase

        // Open Admin Dashboard
        startActivity(
            Intent(this, AdminDashboardActivity::class.java)
        )

        finish()
    }
}