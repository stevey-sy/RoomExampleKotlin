package com.example.roomexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "todo-do"
        )
                .allowMainThreadQueries()
                .build()

        val result_text : TextView = findViewById(R.id.result_text)
//        result_text.text = db.todoDao().getAll().toString()

        db.todoDao().getAll()
                .observe(this, Observer {
                    result_text.text = it.toString()
                })
                .toString()

        val edit_text : EditText = findViewById(R.id.todo_edit)

        val add_button : Button = findViewById(R.id.add_button)
        add_button.setOnClickListener {
            db.todoDao().insert(Todo(edit_text.text.toString()))
//            result_text.text = db.todoDao().getAll().toString()
        }
    }
}