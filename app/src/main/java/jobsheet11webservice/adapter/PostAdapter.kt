package com.anugrah.belajarkotlin.jobsheet11webservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R
import com.anugrah.belajarkotlin.jobsheet11webservice.model.PostResponse

class PostAdapter(private val list: ArrayList<PostResponse>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvResponse: TextView = itemView.findViewById(R.id.tvResponse)

        fun bind(post: PostResponse) {
            val text = "userId: ${post.userId}\n" +
                    "id: ${post.id}\n" +
                    "title: ${post.title}"
            tvResponse.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(list[position])
    }
}