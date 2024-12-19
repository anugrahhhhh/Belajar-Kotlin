package com.anugrah.belajarkotlin.jobsheet11webservice.activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R
import com.anugrah.belajarkotlin.jobsheet11webservice.adapter.UserAdapter
import com.anugrah.belajarkotlin.jobsheet11webservice.api.RetrofitClient
import com.anugrah.belajarkotlin.jobsheet11webservice.model.User
import com.anugrah.belajarkotlin.jobsheet11webservice.model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {

    private var list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        showUsers()
    }

    private fun showUsers() {
        val rvUser = findViewById<RecyclerView>(R.id.rvUser)
        val tvResponseCode = findViewById<TextView>(R.id.tvResponseCode)

        rvUser.setHasFixedSize(true)
        rvUser.layoutManager = LinearLayoutManager(this)

        RetrofitClient.instance.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                tvResponseCode.text = t.message
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                tvResponseCode.text = response.code().toString()
                val listResponse = response.body()?.data
                listResponse?.let { list.addAll(it) }
                val adapter = UserAdapter(list)
                rvUser.adapter = adapter
            }
        })
    }
}
