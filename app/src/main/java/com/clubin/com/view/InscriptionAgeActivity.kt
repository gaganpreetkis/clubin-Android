package com.clubin.com.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.clubin.com.R

class InscriptionAgeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription_age)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, InscriptionNameActivity::class.java)
            startActivity(intent)
        }
    }
}