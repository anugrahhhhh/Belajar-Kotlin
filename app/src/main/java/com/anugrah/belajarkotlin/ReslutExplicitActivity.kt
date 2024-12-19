package com.anugrah.belajarkotlin

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ResultExplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reslut_explicit)
        val message = intent.getStringExtra("EXTRA_MESSAGE")
        findViewById<TextView>(R.id.textresultexplicit).text = message
    }
}