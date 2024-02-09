package com.example.backuprestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.backuprestore.db.User
import com.example.backuprestore.ui.theme.BackupRestoreTheme

internal class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    val viewModel = MainViewModel(application)
    setContent {
      BackupRestoreTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
          val users by viewModel.users.collectAsStateWithLifecycle()
          App(
            users,
            { name: String -> viewModel.addUser(name) },
            modifier = Modifier.padding(innerPadding))
        }
      }
    }
  }

  @Composable
  private fun App(
    users: List<User>,
    onAddUser: (String) -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Column(modifier = modifier) {
      Text("Num users: ${users.size}")

      TextButton(onClick = { onAddUser("Foo") }) {
        Text("Add user")
      }
    }
  }
}
