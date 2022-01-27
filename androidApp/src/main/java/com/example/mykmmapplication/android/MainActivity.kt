package com.example.mykmmapplication.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mykmmapplication.Greeting
import android.widget.TextView
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private val greeting = Greeting()
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "Loading .. "

        scope.launch {
            kotlin.runCatching {
                greeting.greeting()
            }.onSuccess {
                tv.text = it
            }.onFailure {
                tv.text = "Error :${it.localizedMessage}"
            }
        }
    }
}
