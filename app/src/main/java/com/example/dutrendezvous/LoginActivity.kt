package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.txtLoginEmail)
        val etPassword = findViewById<EditText>(R.id.txtLoginPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegisterLink = findViewById<TextView>(R.id.tvForgotPass)

        val registeredEmail = intent.getStringExtra("REGISTERED_EMAIL")
        val registeredPassword = intent.getStringExtra("REGISTERED_PASSWORD")

        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString()
            val inputPassword = etPassword.text.toString()

            if (inputEmail == registeredEmail &&
                inputPassword == registeredPassword) {

                Toast.makeText(
                    this,
                    "Login Successful! (Homepage coming soon)",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Incorrect email or password!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        tvRegisterLink.setOnClickListener {
            startActivity(
                Intent(this, RegisterActivity::class.java)
            )
            finish()
        }
    }
}