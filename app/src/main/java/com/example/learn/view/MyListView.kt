package com.example.learn.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.ListView
import kotlin.math.abs

class MyListView : ListView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    companion object {
        const val TAG = "MyListView1"
    }

    val touchSlop = ViewConfiguration.get(context).scaledPagingTouchSlop
    var mLastX = 0
    var mLastY = 0
    var mIsBeingDragged = false
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

        val result = super.dispatchTouchEvent(ev)
        Log.d(TAG, "dispatchTouchEvent action:${ev?.action} result:$result")

        when (ev?.action) {
            MotionEvent.ACTION_DOWN -> {
                requestDisallowInterceptTouchEvent(true)
                mIsBeingDragged = false
            }
            MotionEvent.ACTION_MOVE -> {

                val limitx = abs(ev.x - mLastX)
                val limity = abs(ev.y - mLastY)

                Log.d(TAG, "dispatchTouchEvent: x:$limitx,y:$limity,touchSlop$touchSlop")
                if (limitx < touchSlop && limity < touchSlop) {
                    return result
                }
                if (limitx > limity && !mIsBeingDragged) {
                    requestDisallowInterceptTouchEvent(false)
                } else {
                    Log.d(TAG, "dispatchTouchEvent is being dragged!")
                    mIsBeingDragged = true
                }
            }
            MotionEvent.ACTION_DOWN -> requestDisallowInterceptTouchEvent(true)
        }
        mLastX = ev!!.x.toInt()
        mLastY = ev.y.toInt()
        return result
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        val result = super.onInterceptTouchEvent(ev)
        Log.d(TAG, "onInterceptTouchEvent action:${ev?.action} result:$result")
        return result
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        val result = super.onTouchEvent(ev)
        Log.d(TAG, "onTouchEvent action:${ev?.action} result:$result")
        return result
    }
//
//    override fun requestDisallowInterceptTouchEvent(disallowIntercept:Boolean){
//        Log.d(TAG, "requestDisallowInterceptTouchEvent :$disallowIntercept")
//    }
}