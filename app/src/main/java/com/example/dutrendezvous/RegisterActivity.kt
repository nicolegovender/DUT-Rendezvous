package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        val etFullName = findViewById<EditText>(R.id.txtFullName)
        val etPhone = findViewById<EditText>(R.id.txtPhone)
        val etEmail = findViewById<EditText>(R.id.txtEmail)
        val etPassword = findViewById<EditText>(R.id.txtPassword)

        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvLoginLink = findViewById<TextView>(R.id.tvLoginLink)

        btnRegister.setOnClickListener {

            val fullName = etFullName.text.toString()
            val phone = etPhone.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (fullName.isEmpty() ||
                phone.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty()
            ) {
                Toast.makeText(
                    this,
                    "Please fill in all fields",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val dbHelper = DatabaseHelper(this)

            val success =
                dbHelper.insertUser(
                    fullName,
                    phone,
                    email,
                    password
                )

            if (success) {

                Toast.makeText(
                    this,
                    "Registration Successful!",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this,
                        LoginActivity::class.java
                    )
                )

                finish()

            } else {

                Toast.makeText(
                    this,
                    "Registration Failed",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        tvLoginLink.setOnClickListener {
            startActivity(
                Intent(this, LoginActivity::class.java)
            )
            finish()
        }
    }
}