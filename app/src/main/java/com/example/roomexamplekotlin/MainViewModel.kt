package com.example.roomexamplekotlin

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

}

class MainAndroidViewModel(application: Application) : AndroidViewModel(application) {

    // MainAndroidViewModel 에서만 db 접근 가능하도록 하기 위해서
    // 접근제어자를 private 사용
   private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java, "todo-do"
    )
        .allowMainThreadQueries()
        .build()

    var todos: LiveData<List<Todo?>?>

    var newTodo: String? = null

    init {
        todos = getAll()
    }

    fun getAll(): LiveData<List<Todo?>?> {
        return db.todoDao().getAll()
    }

    fun insert(todo : String) {
//        viewModelScope.launch(Dispatchers.IO) {
//
//        }
        db.todoDao().insert(Todo(todo))
    }

}