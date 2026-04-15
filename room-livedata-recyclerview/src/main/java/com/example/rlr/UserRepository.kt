package com.example.rlr

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData

class UserRepository(application: Application) {
    private val db: AppDatabase = AppDatabase.getInstance(application)
    private val userDao: UserDao = db.userDao()

    fun getUsers(): LiveData<List<User?>?>? {
        val data = userDao.getAllUsers()
        return data
    }

    fun insert(user: User) {
        Log.d("UserRepository", "insert user: $user")
        Thread {
            userDao.insert(user)
        }.start()
    }
}
