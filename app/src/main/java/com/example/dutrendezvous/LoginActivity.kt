package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
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


        val tvRegisterLink = findViewById<TextView>(R.id.tvRegisterLink)
        val tvStaffLogin = findViewById<TextView>(R.id.tvStaffLogin)

        val tvAboutUs =
            findViewById<TextView>(R.id.tvAboutUs)
        tvAboutUs.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AboutActivity::class.java
                )
            )
        }

        var passwordVisible = false

        etPassword.setOnTouchListener { _, event ->

            val drawableRight = 2

            if (event.action == MotionEvent.ACTION_UP) {

                if (event.rawX >= (
                            etPassword.right -
                                    etPassword.compoundDrawables[drawableRight].bounds.width()
                            )
                ) {

                    passwordVisible = !passwordVisible

                    if (passwordVisible) {
                        etPassword.transformationMethod =
                            HideReturnsTransformationMethod.getInstance()
                    } else {
                        etPassword.transformationMethod =
                            PasswordTransformationMethod.getInstance()
                    }

                    etPassword.setSelection(etPassword.text.length)

                    return@setOnTouchListener true
                }
            }

            false
        }

        // LOGIN BUTTON
        btnLogin.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            val dbHelper = DatabaseHelper(this)

            val validUser = dbHelper.checkUser(
                email,
                password
            )

            if (validUser) {

                Toast.makeText(
                    this,
                    "Login Successful!",
                    Toast.LENGTH_SHORT
                ).show()

                val prefs = getSharedPreferences(
                    "UserData",
                    MODE_PRIVATE
                )

                prefs.edit()
                    .putString("email", email)
                    .apply()

                startActivity(
                    Intent(
                        this,
                        HomepageActivity::class.java
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

        // REGISTER LINK
        tvRegisterLink.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )

            finish()
        }

        // FORGOT PASSWORD


        // STAFF LOGIN
        tvStaffLogin.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    StaffLoginActivity::class.java
                )
            )
        }
    }
}