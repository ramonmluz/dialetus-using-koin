package com.example.koinsampleapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Community(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String
)