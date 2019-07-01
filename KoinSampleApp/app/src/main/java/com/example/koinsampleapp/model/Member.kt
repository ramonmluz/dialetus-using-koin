package com.example.koinsampleapp.model

import androidx.room.Embedded
import androidx.room.PrimaryKey

data class Member(
    @PrimaryKey val id: Int,
    val name: String
)

