package com.example.rlr

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users1")
data class User(
    val name: String,
    val password: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
