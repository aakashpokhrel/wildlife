package com.example.wildlifetracking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView

class UserDashboard : AppCompatActivity() {
    private lateinit var btnKoshi: CardView
    private lateinit var btnChitwan: CardView
    private lateinit var btnBardiya: CardView
    private lateinit var btnParsa: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard)

        btnKoshi = findViewById(R.id.btnKoshi)
        btnChitwan = findViewById(R.id.btnChitwan)
        btnBardiya = findViewById(R.id.btnBardiya)
        btnParsa = findViewById(R.id.btnParsa)

        btnKoshi.setOnClickListener {
            val intent = Intent(
                this, MapsActivity::class.java
            )
            startActivity(intent)
        }
        btnChitwan.setOnClickListener {
            val intent = Intent(
                this, MapsActivity2::class.java
            )
            startActivity(intent)
        }
        btnBardiya.setOnClickListener {
            val intent = Intent(
                this, MapsActivity3::class.java
            )
            startActivity(intent)
        }
        btnParsa.setOnClickListener {
            val intent = Intent(
                this, MapsActivity4::class.java
            )
            startActivity(intent)
        }
    }
}