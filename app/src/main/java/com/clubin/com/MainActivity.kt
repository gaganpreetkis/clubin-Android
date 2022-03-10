package com.clubin.com

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.clubin.com.view.PasswordResetEmailActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inscription: TextView = findViewById(R.id.inscription)
        inscription.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetEmailActivity::class.java)
            startActivity(intent)
        }

    }
}