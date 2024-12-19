package com.anugrah.belajarkotlin.jobsheet11webservice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R
import com.anugrah.belajarkotlin.jobsheet11webservice.model.User

class UserAdapter(private val list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvResponse: TextView = itemView.findViewById(R.id.tvResponse)

        fun bind(user: User) {
            val text = "id : ${user.id}\n" +
                    "email: ${user.email}\n" +
                    "first name: ${user.firstName}\n" +
                    "last name: ${user.lastName}"
            tvResponse.text = text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }
}
