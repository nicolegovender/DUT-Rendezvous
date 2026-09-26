package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class StaffLoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.staff_login)

        val etEmail = findViewById<EditText>(R.id.etStaffEmail)
        val etPassword = findViewById<EditText>(R.id.etStaffPassword)
        val cbRememberMe = findViewById<CheckBox>(R.id.cbRememberMe)
        val btnLogin = findViewById<Button>(R.id.btnStaffLogin)
        val imgShowPassword = findViewById<ImageView>(R.id.imgShowPassword)

        var passwordVisible = false

        imgShowPassword.setOnClickListener {

            passwordVisible = !passwordVisible

            if (passwordVisible) {
                etPassword.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                etPassword.transformationMethod =
                    PasswordTransformationMethod.getInstance()
            }

            etPassword.setSelection(etPassword.text.length)
        }

        btnLogin.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val rememberMe = cbRememberMe.isChecked

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Please enter both email and password",
                    Toast.LENGTH_SHORT
                ).show()

                return@setOnClickListener
            }

            if (
                email == "staff@rendezvous.com" &&
                password == "password123"
            ) {

                if (rememberMe) {
                    // Optional future SharedPreferences code
                }

                Toast.makeText(
                    this,
                    "Login Successful!",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this,
                        AdminDashboardActivity::class.java
                    )
                )

                finish()

            } else {

                Toast.makeText(
                    this,
                    "Invalid email or password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}