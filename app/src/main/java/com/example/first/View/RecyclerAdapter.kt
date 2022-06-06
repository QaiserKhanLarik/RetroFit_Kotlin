package com.example.first.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.first.Model.Users
import com.example.first.R
import com.google.gson.JsonElement

class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var userList : List<Users> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.name.text = userList.get(position).name
        holder.email.text = userList.get(position).email
        holder.gender.text = userList.get(position).gender

    }

    fun setUsersListItems(userlist: List<Users>){
        this.userList = userlist;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val name: TextView = itemView!!.findViewById(R.id.name)
        val email: TextView = itemView!!.findViewById(R.id.email)
        val gender: TextView = itemView!!.findViewById(R.id.gender)

    }
}