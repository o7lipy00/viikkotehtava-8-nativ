package com.example.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import viewmodel.Todoviewmodel.TodosApi
import viewmodel.Todoviewmodel.Todo
import android.util.Log
import androidx.compose.runtime.mutableStateListOf

class TodoViewModel : ViewModel() {
   var todos = mutableStateListOf<Todo>()
    private set

    init {
        getTodosList()

    }
    private fun getTodosList(){
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            }catch (e: Exception){
                Log.d("TODOVIEWMODEL",e.message.toString())
            }
        }

    }    }