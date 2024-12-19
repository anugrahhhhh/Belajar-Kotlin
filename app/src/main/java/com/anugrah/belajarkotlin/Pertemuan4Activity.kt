package com.anugrah.belajarkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.ProfileActivity
import com.anugrah.belajarkotlin.R

class Pertemuan4Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertemuan4)

        val nameEditText = findViewById<EditText>(R.id.editTextName)
        val ageEditText = findViewById<EditText>(R.id.editTextAge)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString()

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("EXTRA_NAME", name)
            intent.putExtra("EXTRA_AGE", age)
            startActivity(intent)
        }
    }
}