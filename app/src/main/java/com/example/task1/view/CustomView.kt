package com.example.task1.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View



class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    lateinit var bitMap: Bitmap
    lateinit var scaledBitMap: Bitmap


    fun setImageBitmap(bitMap: Bitmap) {
        this.bitMap = bitMap
    }

    override fun onDraw(canvas: Canvas) {
        scaledBitMap = Bitmap.createScaledBitmap(bitMap, canvas.width, canvas.height, true)
        canvas.drawBitmap(scaledBitMap, 0F, 0F, null)
    }
}