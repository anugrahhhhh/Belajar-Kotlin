package com.anugrah.belajarkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.anugrah.belajarkotlin.jobsheet10SharedPreferences.SharedActivity
import com.anugrah.belajarkotlin.jobsheet11webservice.activity.JsonActivity
import com.anugrah.belajarkotlin.jobsheet4layout.LayoutActivity
import com.anugrah.belajarkotlin.jobsheet5dialog.DialogActivity
import com.anugrah.belajarkotlin.jobsheet7adepter.RecycleActivity
import com.anugrah.belajarkotlin.jobsheet8view.MenuView
import com.anugrah.belajarkotlin.jobsheet9notificaton.NotificationActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonStart = findViewById<Button>(R.id.button_start)
        buttonStart.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan3 = findViewById<Button>(R.id.button_pertemuan3)
        buttonPertemuan3.setOnClickListener{
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan4 = findViewById<Button>(R.id.button_pertemuan4)
        buttonPertemuan4.setOnClickListener{
            val intent = Intent(this, Pertemuan4Activity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan5 = findViewById<Button>(R.id.button_fragment)
        buttonPertemuan5.setOnClickListener{
            val intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan6 = findViewById<Button>(R.id.button_pertemuan6)
        buttonPertemuan6.setOnClickListener{
            val intent = Intent(this, LayoutActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan7 = findViewById<Button>(R.id.button_pertemuan7)
        buttonPertemuan7.setOnClickListener{
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan9 = findViewById<Button>(R.id.button_pertemuan9)
        buttonPertemuan9.setOnClickListener{
            val intent = Intent(this, RecycleActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan10 = findViewById<Button>(R.id.button_pertemuan10)
        buttonPertemuan10.setOnClickListener{
            val intent = Intent(this, MenuView::class.java)
            startActivity(intent)
        }
        val buttonPertemuan11 = findViewById<Button>(R.id.button_pertemuan11)
        buttonPertemuan11.setOnClickListener{
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan12 = findViewById<Button>(R.id.button_pertemuan12)
        buttonPertemuan12.setOnClickListener{
            val intent = Intent(this, SharedActivity::class.java)
            startActivity(intent)
        }
        val buttonPertemuan13 = findViewById<Button>(R.id.button_pertemuan13)
        buttonPertemuan13.setOnClickListener{
            val intent = Intent(this, JsonActivity::class.java)
            startActivity(intent)
        }
    }
}