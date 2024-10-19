package com.example.viewmodel.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // Import the correct items function
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.viewmodel.ui.theme.ViewmodelTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.TodoViewModel
import viewmodel.Todoviewmodel.Todo


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewmodelTheme {
                TodoScreen()
            }
        }
    }

    @Composable
    fun TodoScreen(todoViewModel: TodoViewModel = viewModel()) {
        TodoList(todoViewModel.todos)
    }


    @Composable
    fun TodoList(todos: List<Todo>) {  // Change to accept a list of Todo
        LazyColumn(
            modifier = Modifier.padding(8.dp)
        ) {
            items(todos) { todo -> // todo is now a Todo object
                Text(
                    text = todo.title,  // Assuming Todo has a title property
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ViewmodelTheme {
            TodoScreen()
        }
    }
}
