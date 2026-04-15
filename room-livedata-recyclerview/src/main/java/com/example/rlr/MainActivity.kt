package com.example.rlr

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var userViewModel: UserViewModel? = null
    private var adapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.user_rv)
        adapter = UserAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        ViewModelProvider(this)[UserViewModel::class.java].also {
            userViewModel = it
            Log.d("MainActivity", "userViewModel: $userViewModel")
        }

        val addBtn = findViewById<Button>(R.id.btn_add_user)
        addBtn.setOnClickListener {
            val name: EditText = findViewById(R.id.et_name)
            val password: EditText = findViewById<EditText?>(R.id.et_password)
            Log.d(
                "MainActivity",
                "setOnClickListener: name: $name, password: ${password}"
            )
            val user = User(
                name.text.toString(), password.text.toString()
            )
            userViewModel!!.insert(user)
            name.text.clear()
            password.text.clear()
        }

        // 👇 关键：观察 LiveData
        userViewModel!!.getUserList()!!.observe(
            this, { users: List<User?>? ->
                // 当数据库变化时，这个回调会被自动触发
                Log.d("MainActivity", "users: $users")
                adapter!!.setUsers(users) // 调用 adapter.setUsersView()
            })
    }
}
