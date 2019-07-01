package com.example.koinsampleapp.model

import androidx.room.PrimaryKey

data class Member(
    @PrimaryKey val id: Int,
    val name: String,
    val office 
)

