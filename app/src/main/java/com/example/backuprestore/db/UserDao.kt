package com.example.backuprestore.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface UserDao {
    @Query("SELECT * FROM User")
    fun observeAll(): Flow<List<User>>
}
