package com.anugrah.belajarkotlin.jobsheet4layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R

class LayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_layout)

        val buttonLinearLayout = findViewById<Button>(R.id.button_linearlayout)
        buttonLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearlayoutActivity::class.java)
            startActivity(intent)
        }
        val buttonRelativeLayout = findViewById<Button>(R.id.button_relativelayout)
        buttonRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativelayoutActivity::class.java)
            startActivity(intent)
        }
        val buttonConstraintLayout = findViewById<Button>(R.id.button_constraintlayout)
        buttonConstraintLayout.setOnClickListener {
            val intent = Intent(this, Constraintlayout::class.java)
            startActivity(intent)
        }
        val buttonlatihanlayout = findViewById<Button>(R.id.button_latihanlayout)
        buttonlatihanlayout.setOnClickListener {
            val intent = Intent(this, LatihanlayoutActivity::class.java)
            startActivity(intent)
        }
    }
}