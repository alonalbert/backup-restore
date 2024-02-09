package com.example.backuprestore.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        User::class,
    ],
    version = 1,
    exportSchema = true,
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}