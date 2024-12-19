package com.anugrah.belajarkotlin.jobsheet11webservice.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R
import com.anugrah.belajarkotlin.jobsheet11webservice.adapter.PostAdapter
import com.anugrah.belajarkotlin.jobsheet11webservice.api.RetrofitClient
import com.anugrah.belajarkotlin.jobsheet11webservice.model.PostResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostActivity : AppCompatActivity() {

    private lateinit var rvPost: RecyclerView
    private lateinit var tvResponseCode: TextView
    private var list = ArrayList<PostResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        rvPost = findViewById(R.id.rvPost)
        tvResponseCode = findViewById(R.id.tvResponseCode)
        showPosts()
    }

    private fun showPosts() {
        rvPost.setHasFixedSize(true)
        rvPost.layoutManager = LinearLayoutManager(this)

        // Make API call to fetch posts
        RetrofitClient.instance.getPosts().enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                // Display error message
                tvResponseCode.text = "Error: ${t.message}"
                Toast.makeText(this@PostActivity, "Failed to load posts", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                // Display response code
                tvResponseCode.text = "Response code: ${response.code()}"

                // Check if response body is valid
                val listResponse = response.body()
                if (listResponse != null && listResponse.isNotEmpty()) {
                    list.clear()
                    list.addAll(listResponse)
                    val adapter = PostAdapter(list)
                    rvPost.adapter = adapter
                } else {
                    Toast.makeText(this@PostActivity, "No posts available", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}

