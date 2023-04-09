package com.example.learn.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.math.min

class GradientView : View {

    companion object {
        const val TAG = "GradientView"
    }

    var mPaint: Paint = Paint()
    var mColor = Color.RED
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    init {
        mPaint.color = Color.RED
    }

    fun setColor(color: Int) {
        mColor = color
        Log.d(TAG, "setColor: $color")
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
        val width = width
        val height = height
        val radius = min(width, height) / 2
        val rl = LinearGradient(0f,0f,0f,getHeight().toFloat(),mColor,Color.BLACK,Shader.TileMode.CLAMP)
        mPaint.shader = rl
        canvas?.drawRect(0f,0f,width.toFloat(),height.toFloat(),mPaint)
//        canvas?.drawCircle(width / 2f, height / 2f, radius.toFloat(), mPaint)

    }
}