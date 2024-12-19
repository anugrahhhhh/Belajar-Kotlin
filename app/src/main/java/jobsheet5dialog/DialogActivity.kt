package com.anugrah.belajarkotlin.jobsheet5dialog

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.anugrah.belajarkotlin.R

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        // Set title for ActionBar
        supportActionBar?.title = "Dialog Page"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)  // Enable Back Button in ActionBar

        val toastButton = findViewById<Button>(R.id.btn_toast)
        val snackbarButton = findViewById<Button>(R.id.btn_snackbar)
        val dialogButton = findViewById<Button>(R.id.btn_dialog)

        // Toast Handler
        toastButton.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast", Toast.LENGTH_SHORT).show()
        }

        // SnackBar Handler
        snackbarButton.setOnClickListener {
            Snackbar.make(it, "Ini adalah Snackbar", Snackbar.LENGTH_LONG)
                .setAction("Tutup") {
                    Toast.makeText(this, "Snackbar Ditutup", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        // Dialog Handler
        dialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Dialog Contoh")
            builder.setMessage("Apakah Anda ingin melanjutkan?")
            builder.setPositiveButton("Ya") { _, _ ->
                Toast.makeText(this, "Melanjutkan", Toast.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Tidak") { _, _ ->
                Toast.makeText(this, "Dibatalkan", Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }

        // Navigate to HelpActivity
        val buttonlatihandialog = findViewById<Button>(R.id.btn_dialog)
        buttonlatihandialog.setOnClickListener {
            val intent = Intent(this, HelpActivity::class.java)
            startActivity(intent)
        }
    }

    // Inflate the menu in ActionBar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)  // Assuming menu_main.xml is in res/menu
        return true
    }

    // Handle menu item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(this, "Pengaturan dipilih", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help -> {
                val intent = Intent(this, HelpActivity::class.java)
                startActivity(intent)
                true
            }
            android.R.id.home -> {  // Handle Back button press in ActionBar
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}