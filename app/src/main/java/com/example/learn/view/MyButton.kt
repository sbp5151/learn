package com.example.learn.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.Button

class MyButton:androidx.appcompat.widget.AppCompatButton {

    constructor(context:Context):super(context){}
    constructor(context:Context,attrs: AttributeSet):super(context,attrs){}
    companion object{
        const val TAG = "MyButton"
    }
    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        val result =  super.dispatchTouchEvent(event)
        Log.d(TAG, "dispatchTouchEvent: $result")
        return result
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val result = super.onTouchEvent(event)
        Log.d(TAG, "onTouchEvent: $result")
        return result
    }
}