package com.clubin.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.clubin.com.auth.login.view.LoginActivity
import com.clubin.com.auth.onboarding.view.OnboardingActivity

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

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