package com.anugrah.belajarkotlin.jobsheet5dialog

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        // Set judul untuk halaman bantuan
        supportActionBar?.title = "Bantuan"

        // Menambahkan tombol back di ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Handle tombol Back di ActionBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()  // Kembali ke halaman utama
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}