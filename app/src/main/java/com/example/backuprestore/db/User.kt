package com.example.backuprestore.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
internal data class User(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  val name: String = "",
) {
  constructor(name: String) : this(id = 0, name)
}