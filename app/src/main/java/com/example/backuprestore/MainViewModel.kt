package com.example.backuprestore

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.backuprestore.db.AppDatabase
import com.example.backuprestore.db.User
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val StopTimeoutMillis: Long = 5000
private val WhileUiSubscribed: SharingStarted = SharingStarted.WhileSubscribed(StopTimeoutMillis)

internal class MainViewModel(application: Application) : ViewModel() {
  private val db = Room.databaseBuilder(
    application,
    AppDatabase::class.java,
    "database.db"
  ).build()

  val users: StateFlow<List<User>> = db.userDao().observeAll().stateIn(viewModelScope, WhileUiSubscribed, emptyList())

  fun addUser(name: String) {
    viewModelScope.launch {
      db.userDao().insert(User(name))
    }
  }
}
