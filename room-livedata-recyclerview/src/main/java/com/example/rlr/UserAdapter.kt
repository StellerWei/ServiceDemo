package com.example.rlr

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var users: List<User?>? = ArrayList()

    // 👇 这就是 setUsersView() 的实现
    @SuppressLint("NotifyDataSetChanged")
    fun setUsers(users: List<User?>?) {
        this.users = users // 更新内部数据
        notifyDataSetChanged() // 通知 RecyclerView 刷新
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = users?.get(position)
        if (currentUser != null) {
            holder.etName.text = currentUser.name
            holder.etPassword.text = currentUser.password
        }
        if (currentUser != null) {
            holder.etPassword.text = currentUser.password
        }
    }

    override fun getItemCount(): Int {
        return users!!.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var etName: TextView = itemView.findViewById<EditText>(R.id.tv_name)
        var etPassword: TextView = itemView.findViewById<EditText>(R.id.tv_password)
    }
}
