package com.anugrah.belajarkotlin.jobsheet7adepter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.anugrah.belajarkotlin.R

class FruitAdapter(private val fruitList: List<User>) :
    RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView = itemView.findViewById(R.id.ivUser)
        val userName: TextView = itemView.findViewById(R.id.tvUserName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val user = fruitList[position]
        holder.userImage.setImageResource(user.image)
        holder.userName.text = user.name
    }

    override fun getItemCount(): Int = fruitList.size
}
