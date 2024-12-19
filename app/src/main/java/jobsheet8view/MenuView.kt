package com.anugrah.belajarkotlin.jobsheet8view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R

class MenuView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu_view)

        val buttonSearchView = findViewById<Button>(R.id.button_to_searchview)
        buttonSearchView.setOnClickListener {
            val intent = Intent(this, SearchView::class.java)
            startActivity(intent)
        }
        val buttonTabHost = findViewById<Button>(R.id.button_to_tabhost)
        buttonTabHost.setOnClickListener {
            val intent = Intent(this, TabHost::class.java)
            startActivity(intent)
        }
    }
}