package com.example.task1.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View



class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    lateinit var bitMap: Bitmap
    lateinit var dest: RectF


    fun setImageBitmap(bitMap: Bitmap) {
        this.bitMap = bitMap
    }

    override fun onDraw(canvas: Canvas) {
        dest = RectF(0F, 0F, canvas.width.toFloat(), canvas.height.toFloat())
        canvas.drawBitmap(bitMap, null, dest, null)
    }
}