package com.example.backuprestore

import android.app.Application
import androidx.room.Room
import com.example.backuprestore.db.AppDatabase
import kotlin.LazyThreadSafetyMode.NONE

internal class App : Application() {
  val db by lazy(NONE) {
    Room.databaseBuilder(
      this,
      AppDatabase::class.java,
      "pad-database.db"
    ).build()
  }

  override fun onCreate() {
    super.onCreate()
  }
}