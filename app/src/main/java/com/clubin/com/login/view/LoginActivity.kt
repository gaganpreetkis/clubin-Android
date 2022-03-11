package com.clubin.com.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.clubin.com.R
import com.clubin.com.passwordreset.PasswordResetEmailActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button: TextView = findViewById(R.id.textViewDetails)
        button.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetEmailActivity::class.java)
            startActivity(intent)
        }
    }
}