package com.anugrah.belajarkotlin.jobsheet10SharedPreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R

class SharedActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private lateinit var editTextName: EditText
    private lateinit var checkBoxLogin: CheckBox
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        // Find views by ID
        editTextName = findViewById(R.id.editTextName)
        checkBoxLogin = findViewById(R.id.checkBoxLogin)
        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)
        tvResult = findViewById(R.id.tvResult)

        // Save button
        btnSave.setOnClickListener {
            val name = editTextName.text.toString()
            val isLoggedIn = checkBoxLogin.isChecked
            if (name.isNotEmpty()) {
                editor.putString("user_name", name)
                editor.putBoolean("is_logged_in", isLoggedIn)
                editor.apply() // Apply data yang disimpan
            }
        }

        // Load button
        btnLoad.setOnClickListener {
            val name = sharedPreferences.getString("user_name", "No name saved")
            val isLoggedIn = sharedPreferences.getBoolean("is_logged_in", false)
            val status = if (isLoggedIn) "Logged In" else "Logged Out"
            tvResult.text = "Name: $name\nStatus: $status"
        }
    }
}
