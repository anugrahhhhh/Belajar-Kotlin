package com.anugrah.belajarkotlin.jobsheet8view

import android.os.Bundle
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R

class SearchView : AppCompatActivity() {

    private val userList = listOf(
        User(name = "Anugrah PutraAl Fatih", email = "anugahputra270@gmail.com"),
        User(name = "Budi Utomo", email = "budi@gmail.com"),
        User(name = "Citra Putri", email = "citra@gmail.com")
    )
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_host)

        val searchView = findViewById<SearchView>(R.id.searchView)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        userAdapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterUsers(newText.orEmpty())
                return true
            }
        })
    }

    private fun filterUsers(query: String) {
        val filteredUsers = userList.filter { it.name.contains(query, ignoreCase = true) }
        userAdapter.updateList(filteredUsers)
    }
}
