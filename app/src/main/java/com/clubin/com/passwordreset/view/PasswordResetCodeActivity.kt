package com.clubin.com.passwordreset.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.clubin.com.R
import com.clubin.com.passwordreset.PasswordResetNewPasswordActivity

class PasswordResetCodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_reset_code_actitvity);

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            intent = Intent(applicationContext, PasswordResetNewPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}