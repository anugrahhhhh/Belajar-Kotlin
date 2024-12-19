package com.anugrah.belajarkotlin.jobsheet8view

import android.os.Bundle
import android.widget.TabHost
import androidx.appcompat.app.AppCompatActivity
import com.anugrah.belajarkotlin.R

class TabHost : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_host)

        val tabHost = findViewById<TabHost>(R.id.tabHost)
        tabHost.setup()

        // Menambahkan Tab Pertama
        var spec = tabHost.newTabSpec("Tab Satu")
        spec.setContent(R.id.tab1)
        spec.setIndicator("Cari Pengguna")
        tabHost.addTab(spec)

        // Menambahkan Tab Kedua
        spec = tabHost.newTabSpec("Tab Dua")
        spec.setContent(R.id.tab2)
        spec.setIndicator("Tab 2")
        tabHost.addTab(spec)
    }
}
