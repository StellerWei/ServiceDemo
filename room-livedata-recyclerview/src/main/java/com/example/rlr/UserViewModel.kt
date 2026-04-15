package com.example.rlr

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class UserViewModel(application: Application) : AndroidViewModel(application) {
    var repository: UserRepository = UserRepository(application)
    private val allUsers: LiveData<List<User?>?>? = repository.getUsers()

    fun getUserList(): LiveData<List<User?>?>? {
        return allUsers
    }

    fun insert(user : User) {
        Log.d("UserViewModel", "insert user: $user")
        repository.insert(user)
    }
}
