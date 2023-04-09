package com.example.learn.view

import android.content.Context
import android.graphics.Canvas
import android.widget.TextView

class MyTextView(context: Context?) : androidx.appcompat.widget.AppCompatTextView(context!!) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}