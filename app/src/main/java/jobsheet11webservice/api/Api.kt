package com.anugrah.belajarkotlin.jobsheet11webservice.api

import com.anugrah.belajarkotlin.jobsheet11webservice.model.PostResponse
import com.anugrah.belajarkotlin.jobsheet11webservice.model.UserResponse
import  retrofit2.Call
import  retrofit2.http.GET

interface Api {
    @GET("users")
    fun getUsers(): Call<UserResponse>

    @GET("https://jsonplaceholder.typicode.com/posts")
    fun getPosts(): Call<ArrayList<PostResponse>>
}