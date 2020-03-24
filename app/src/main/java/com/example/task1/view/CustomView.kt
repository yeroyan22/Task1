package com.example.task1.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import kotlin.math.roundToInt


class CustomView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var bitMap: Bitmap
    private var left: Float = 0F
    private var top: Float = 0F
    private var ratio: Float = 0F
    private var newWidth: Float = 0F
    private var newHeight: Float = 0F


    fun setImageBitmap(bitMap: Bitmap) {
        this.bitMap = bitMap
    }

    override fun onDraw(canvas: Canvas) {
        if(bitMap.width > canvas.width || bitMap.height > canvas.height){
            if (canvas.width <= canvas.height) {
                ratio = bitMap.width / bitMap.height.toFloat()
                newWidth = canvas.width.toFloat()
                newHeight = newWidth / ratio
                canvas.save()
                canvas.scale(
                    newWidth/bitMap.width,
                    newHeight/bitMap.height)
            } else {
                ratio = bitMap.height.toFloat() / bitMap.width.toFloat()
                newHeight = canvas.height.toFloat()
                newWidth = newHeight / ratio
                canvas.save()
                canvas.scale(
                    newWidth/bitMap.width,
                    newHeight/bitMap.height)
            }
            canvas.drawBitmap(bitMap, 0F, 0F, null)
            canvas.restore()
        } else {
            left = ((canvas.width - bitMap.width) / 2).toFloat()
            top = ((canvas.height - bitMap.height) / 2).toFloat()
            canvas.drawBitmap(bitMap, left, top, null)
        }
    }
}