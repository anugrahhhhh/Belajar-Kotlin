package com.anugrah.belajarkotlin.jobsheet11webservice.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R
import com.anugrah.belajarkotlin.jobsheet11webservice.activity.PostActivity


class JsonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)

        val btnUser = findViewById<Button>(R.id.btnUser)
        val btnPost = findViewById<Button>(R.id.btnPost)

        btnUser.setOnClickListener {
            Intent(this@JsonActivity, UserActivity::class.java).also {
                startActivity(it)
            }
        }

        btnPost.setOnClickListener {
            Intent(this@JsonActivity, PostActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}