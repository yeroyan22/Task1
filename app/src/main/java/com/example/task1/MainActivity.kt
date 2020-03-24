package com.example.task1

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.task1.view.CustomView
import java.io.BufferedInputStream

class MainActivity : AppCompatActivity() {

    private lateinit var customView: CustomView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputStream = BufferedInputStream(this.assets.open("hippo.jpg"))
        val bitMap = BitmapFactory.decodeStream(inputStream)


        customView = findViewById(R.id.custom)
        customView.setImageBitmap(bitMap)
    }
}
