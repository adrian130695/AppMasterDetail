package com.example.appmasterdetail.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appmasterdetail.R
import com.example.appmasterdetail.model.Results

class UserAdapter(private var userModelList: ArrayList<Results>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val userImage: ImageView = view.findViewById(R.id.ivPhoto)
        private val userName: TextView = view.findViewById(R.id.tvName)
        val itemUser: View = view.findViewById(R.id.itemUser)

        fun render(userModel: Results) {
            Glide.with(userName.context).load(userModel.picture?.large.toString()).into(userImage)
            userName.text = userModel.name?.first.toString()
            userName.text = userModel.name?.first.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, p: Int) {
        val item = userModelList[p]
        val context = holder.itemUser.context
        holder.render(item)
        holder.itemUser.setOnClickListener {
            context.startActivity(
                Intent(context, UserActivity::class.java)
                    .putExtra(
                        "userName",
                        "${item.name?.first.toString()} ${item.name?.last.toString()}"
                    )
                    .putExtra("userPhone", item.phone)
                    .putExtra("userEmail", item.email)
                    .putExtra("userPicture", item.picture?.large.toString())
            )
        }
    }

    override fun getItemCount(): Int = userModelList.size

}


