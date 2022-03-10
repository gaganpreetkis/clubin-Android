package com.clubin.com.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.clubin.com.R


class InscriptionEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription_email)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, InscriptionPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}