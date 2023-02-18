package com.kistasi.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kistasi.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {
                var task by remember {
                    mutableStateOf("")
                }

                var tasks by remember {
                    mutableStateOf(listOf<String>())
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row {
                        OutlinedTextField(
                            value = task,
                            onValueChange = { text -> task = text },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(
                            onClick = {
                                if (task.isNotBlank()) {
                                    tasks = tasks + task
                                    task = ""
                                }
                            }
                        ) {
                            Text(text = "Add task")
                        }
                    }

                    LazyColumn {
                        items(tasks) { currentTask ->
                            Text(
                                text = currentTask,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                            Divider()
                        }
                    }
                }
            }
        }
    }
}
