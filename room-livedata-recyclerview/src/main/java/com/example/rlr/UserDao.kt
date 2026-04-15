package com.example.rlr

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users1 ORDER BY name ASC")
    fun getAllUsers(): LiveData<List<User?>?>? // 返回 LiveData

    @Insert
    fun insert(user: User) : Long

    @Delete
    fun delete(user: User?)
}
