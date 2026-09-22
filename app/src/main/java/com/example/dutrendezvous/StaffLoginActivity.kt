package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StaffLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staff_login) // Matches your XML file name

        // 1. Connect Kotlin variables to the XML views using the IDs you just added
        val etEmail = findViewById<EditText>(R.id.etStaffEmail)
        val etPassword = findViewById<EditText>(R.id.etStaffPassword)
        val cbRememberMe = findViewById<CheckBox>(R.id.cbRememberMe)
        val btnLogin = findViewById<Button>(R.id.btnStaffLogin)

        // 2. Set up the button click listener
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val rememberMe = cbRememberMe.isChecked

            // 3. Basic Validation
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 4. Login Logic (Replace with real authentication later)
            if (email == "staff@rendezvous.com" && password == "password123") {

                // If remember me is checked, you would save the login state here
                if (rememberMe) {
                    // Save login session (e.g., SharedPreferences)
                }

                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                // 5. Navigate to Admin Dashboard
                val intent = Intent(this, AdminDashboardActivity::class.java)
                startActivity(intent)
                finish() // Closes StaffLoginActivity so the user can't press 'Back' to return to it

            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}