package com.example.koinsampleapp.model

import androidx.room.PrimaryKey

data class OfficeType(
    @PrimaryKey val id: Int,
    val name: String
)