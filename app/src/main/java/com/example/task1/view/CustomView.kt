package com.example.task1.view

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View
import java.io.BufferedInputStream


class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    fun setImageBitmap(name: String) {
        val inputStream = BufferedInputStream(context.assets.open(name))
        val bitMap = BitmapFactory.decodeStream(inputStream)
        val drawable = BitmapDrawable(resources, bitMap)
        this.background = drawable
    }
}