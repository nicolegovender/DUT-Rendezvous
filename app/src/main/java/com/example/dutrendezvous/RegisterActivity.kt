package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. Links to your register XML layout
        setContentView(R.layout.activity_register)

        // 2. Find the views by their IDs from activity_register.xml
        // IMPORTANT: These IDs must match your XML exactly!
        val etFullName = findViewById<EditText>(R.id.txtFullName)
        val etPhone = findViewById<EditText>(R.id.txtPhone)
        val etEmail = findViewById<EditText>(R.id.txtEmail)
        val etPassword = findViewById<EditText>(R.id.txtPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        // This finds the "Login" text at the bottom of your register screen
        // You will need to make sure this ID exists in your XML!
        val tvLoginLink = findViewById<TextView>(R.id.tvLoginLink)

        // 3. Register Button Click Listener
        btnRegister.setOnClickListener {
            // Grab the user input
            val fullName = etFullName.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // --- OPTIONAL: Check if any fields are empty ---
            if (fullName.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener // Stops the code here if fields are empty
            }

            // 4. Send the email and password to the Login screen
            val intent = Intent(this, LoginActivity::class.java)

            // Attach the data with the exact keys LoginActivity is expecting
            intent.putExtra("REGISTERED_EMAIL", email)
            intent.putExtra("REGISTERED_PASSWORD", password)

            // 5. Go to the Login screen
            startActivity(intent)
            finish() // Close the register screen
        }

        // 6. "Already have an account? Login" Click Listener
        tvLoginLink.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}