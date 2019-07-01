package com.example.koinsampleapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.koinsampleapp.model.Community

@Database(entities = arrayOf(Community::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CommunityDao()

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        const val COMMUNITY_DATABASE = "Community_database"

        fun getDatabase(contex: Context): AppDatabase {

            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    contex.applicationContext,
                    AppDatabase::class.java,
                    COMMUNITY_DATABASE
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}