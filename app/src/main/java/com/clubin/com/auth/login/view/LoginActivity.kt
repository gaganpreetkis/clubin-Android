package com.clubin.com.auth.login.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.clubin.com.R
import com.clubin.com.auth.passwordreset.view.PasswordResetEmailActivity
import com.clubin.com.tabbar.TabBarActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textViewDetails: TextView = findViewById(R.id.textViewDetails)
        textViewDetails.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetEmailActivity::class.java)
            startActivity(intent)
        }
        val button: TextView = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, TabBarActivity::class.java)
            startActivity(intent)
            finishAffinity();
        }
    }
}