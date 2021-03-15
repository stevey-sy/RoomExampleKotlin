package com.example.roomexamplekotlin

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
// data class 를 선언하게 되면
// getter setter 를 구현하지 않아도 자동으로 처리 한다.
data class Todo (var title: String) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}