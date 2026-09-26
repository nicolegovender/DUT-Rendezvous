package com.example.dutrendezvous

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.txtLoginEmail)
        val etPassword = findViewById<EditText>(R.id.txtLoginPassword)
        var passwordVisible = false

        etPassword.setOnTouchListener { _, event ->

            val drawableRight = 2

            if (event.action == android.view.MotionEvent.ACTION_UP) {

                if (event.rawX >= (etPassword.right -
                            etPassword.compoundDrawables[drawableRight].bounds.width())
                ) {

                    passwordVisible = !passwordVisible

                    if (passwordVisible) {

                        etPassword.transformationMethod =
                            HideReturnsTransformationMethod.getInstance()

                    } else {

                        etPassword.transformationMethod =
                            PasswordTransformationMethod.getInstance()
                    }

                    etPassword.setSelection(
                        etPassword.text.length
                    )

                    return@setOnTouchListener true
                }
            }

            false
        }
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val tvForgotPass = findViewById<TextView>(R.id.tvForgotPass)
        val tvRegisterLink = findViewById<TextView>(R.id.tvRegisterLink)
        val tvStaffLogin = findViewById<TextView>(R.id.tvStaffLogin)



        btnLogin.setOnClickListener {
            btnLogin.setOnClickListener {

                val email =
                    etEmail.text.toString().trim()

                val password =
                    etPassword.text.toString().trim()

                val dbHelper =
                    DatabaseHelper(this)

                val validUser =
                    dbHelper.checkUser(
                        email,
                        password
                    )

                if (validUser) {

                    Toast.makeText(
                        this,
                        "Login Successful!",
                        Toast.LENGTH_SHORT
                    ).show()

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

            tvRegisterLink.setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        RegisterActivity::class.java
                    )
                )

                finish()
            }

            tvForgotPass.setOnClickListener {

                Toast.makeText(
                    this,
                    "Forgot Password feature coming soon",
                    Toast.LENGTH_SHORT
                ).show()
            }

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
}