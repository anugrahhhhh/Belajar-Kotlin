package com.anugrah.belajarkotlin.jobsheet7adepter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R

class RecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        val userList = listOf(
            User("Nugi", R.drawable.anugrah),
            User("Anugrah Putra Al Fatih", R.drawable.anugrah)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rvUser)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FruitAdapter(userList)
    }
}
