package com.example.koinsampleapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.koinsampleapp.model.Community

@Dao
interface CommunityDao {

    @Query("SELECT * FROM Community ORDER BY name ASC")
    fun getAll(): List<Community>

    @Insert
    fun Insert(communty: Community)


    @Query("DELETE FROM Community ")
    fun deleteAll()
}