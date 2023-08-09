package com.catostudio.humanresource.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.catostudio.humanresource.R
import com.catostudio.humanresource.database.User

class UserAdapter: RecyclerView.Adapter<UserAdapter.ViewHolder>()  {



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val username: TextView = itemView.findViewById(R.id.username)
        val userimage: ImageView = itemView.findViewById(R.id.user_image)
    }

    var data = listOf<User>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun getItemCount()= data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         val item = data[position]
         val res = holder.itemView.context.resources
         holder.username.text = item.username
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_user, parent,false)
        return  ViewHolder(view)
    }



}