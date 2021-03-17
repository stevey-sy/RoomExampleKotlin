package com.example.roomexamplekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.ViewModelStoreOwner
import androidx.room.Room
import com.example.roomexamplekotlin.databinding.ActivityMainBinding
import kotlinx.coroutines.channels.Channel
import org.jetbrains.annotations.NotNull

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        // live data 가 데이터의 변화를 감지할 때
        // binding 객체에 알려서 ui 를 갱신시키기 위해 사용하는 코드
        binding.lifecycleOwner = this

//        val result_text : TextView = findViewById(R.id.result_text)

//    val mainViewModel by viewModels<MainViewModel>()
//    val mainVieModel2 = ViewModelProvider(this).get(MainViewModel::class.java)
//    val mainViewModel3 : MainViewModel by viewModels()

        // UI controller 의 역할을 분리할 view model 객체 생성
        val mainAndroidViewModel by viewModels<MainAndroidViewModel>()
        // binding 객체에 view model 을 세팅한다.
        // 그렇게 되면, view 가 view model 을 구독하도록 설정하게 된 것.
        binding.viewModel = mainAndroidViewModel


        // view model 에서 db를 호출, 데이터 조회
//        mainAndroidViewModel.getAll()
//            .observe(this, Observer {
//                result_text.text = it.toString()
//            })
//            .toString()

        // view model 생성전
        // UI controller 에서 db를 호출하는 코드
//        val db = Room.databaseBuilder(
//                applicationContext,
//                AppDatabase::class.java, "todo-do"
//        )
//                .allowMainThreadQueries()
//                .build()

//        result_text.text = db.todoDao().getAll().toString()

        // Ui controller 에서 직접 db에 접근하는 경우
//        db.todoDao().getAll()
//                .observe(this, Observer {
//                    result_text.text = it.toString()
//                })
//                .toString()

//        val edit_text : EditText = findViewById(R.id.todo_edit)
//
//        val add_button : Button = findViewById(R.id.add_button)
//        add_button.setOnClickListener {
//            //view model 생성 전
//            // UI Controller 에서 db 에 데이터를 직접 추가하는 코드
////            db.todoDao().insert(Todo(edit_text.text.toString()))
////            result_text.text = db.todoDao().getAll().toString()
//            // view model 생성 후
//            // view model 에서 db 에 접근하여 데이터를 추가하는 코드
////            mainAndroidViewModel.insert(Todo(edit_text.text.toString()))
//        }
    }
}