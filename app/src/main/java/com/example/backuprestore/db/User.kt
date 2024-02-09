package com.example.backuprestore.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
internal data class User(
  @PrimaryKey val id: Long = 0,
  val name: String = "",
)