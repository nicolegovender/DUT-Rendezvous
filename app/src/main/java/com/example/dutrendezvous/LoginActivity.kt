package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 1. IMPORTANT: Links to your actual login XML layout (not login2)
        setContentView(R.layout.activity_login)

        // 2. Find the views by their IDs from your XML
        val etEmail = findViewById<EditText>(R.id.txtLoginEmail)
        val etPassword = findViewById<EditText>(R.id.txtLoginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        // Only use this line if you added the "Register here" TextView to your login XML
        val tvRegisterLink = findViewById<TextView>(R.id.tvForgotPass)

        // 3. Get the saved credentials from the Register screen
        val registeredEmail = intent.getStringExtra("REGISTERED_EMAIL")
        val registeredPassword = intent.getStringExtra("REGISTERED_PASSWORD")

        // 4. Login Button Click Listener
        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString()
            val inputPassword = etPassword.text.toString()

            if (inputEmail == registeredEmail && inputPassword == registeredPassword) {
                // SUCCESS: Open the Homepage
                // SUCCESS (Temporary - will change to HomepageActivity after merge)
                Toast.makeText(this, "Login Successful! (Homepage coming soon)", Toast.LENGTH_LONG).show()
            } else {
                // FAILURE
                Toast.makeText(this, "Incorrect email or password!", Toast.LENGTH_SHORT).show()
            }
        }

        // 5. Register Link Click Listener (only if you added the TextView to your XML)
        tvRegisterLink.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}