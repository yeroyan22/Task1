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
    private lateinit var scaledBitmap: Bitmap
    private var left: Float = 0F
    private var top: Float = 0F
    private var ratio: Float = 0F
    private var newWidth: Int = 0
    private var newHeight: Int = 0


    fun setImageBitmap(bitMap: Bitmap) {
        this.bitMap = bitMap
    }

    override fun onDraw(canvas: Canvas) {
        if(bitMap.width > canvas.width || bitMap.height > canvas.height){
            scaledBitmap = if(bitMap.width > bitMap.height){
                ratio = bitMap.width/bitMap.height.toFloat()
                newWidth = canvas.width
                newHeight = (newWidth / ratio).roundToInt()
                Bitmap.createScaledBitmap(this.bitMap, newWidth, newHeight, false)
            } else {
                ratio = bitMap.height/bitMap.width.toFloat()
                newHeight = canvas.height
                newWidth = (newHeight / ratio).roundToInt()
                Bitmap.createScaledBitmap(this.bitMap, newWidth, newHeight, false)
            }

            if (bitMap.height == bitMap.width){
                scaledBitmap = if(canvas.width < canvas.height){
                    ratio = bitMap.width/bitMap.height.toFloat()
                    newWidth = canvas.width
                    newHeight = (newWidth / ratio).roundToInt()
                    Bitmap.createScaledBitmap(this.bitMap, newWidth, newHeight, false)
                } else {
                    ratio = bitMap.height/bitMap.width.toFloat()
                    newHeight = canvas.height
                    newWidth = (newHeight / ratio).roundToInt()
                    Bitmap.createScaledBitmap(this.bitMap, newWidth, newHeight, false)
                }
            }
            left = ((canvas.width - scaledBitmap.width) / 2).toFloat()
            top = ((canvas.height - scaledBitmap.height) / 2).toFloat()
            canvas.drawBitmap(scaledBitmap, left, top, null)
        } else {
            left = ((canvas.width - bitMap.width) / 2).toFloat()
            top = ((canvas.height - bitMap.height) / 2).toFloat()
            canvas.drawBitmap(bitMap, left, top, null)
        }
    }
}