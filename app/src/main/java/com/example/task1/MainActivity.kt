package com.example.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task1.view.CustomView

class MainActivity : AppCompatActivity() {

    private lateinit var customView: CustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customView = findViewById(R.id.custom)
        customView.setImageBitmap("sky.jpg")
    }
}
