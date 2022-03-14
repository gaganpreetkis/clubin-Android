package com.clubin.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.clubin.com.login.view.LoginActivity
import com.clubin.com.onboarding.view.OnboardingActivity

class Inscription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inscription)

        val inscription: TextView = findViewById(R.id.inscription)
        inscription.setOnClickListener {
            intent = Intent(applicationContext, OnboardingActivity::class.java)
            startActivity(intent)
        }

        val loginText: TextView = findViewById(R.id.loginText)
        loginText.setOnClickListener {
            intent = Intent(applicationContext, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}