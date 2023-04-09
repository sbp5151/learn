package com.example.learn.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.HorizontalScrollView
import android.widget.ScrollView

class MyScrollView : HorizontalScrollView {

    /**
     * 一：view的基础知识
     * 1、view的位置（原始）：top、bottom、left、right;
     * 2、x、y、translationX、translationY：左上角坐標，隨著view移動發生改變;
     * 3、MotionEvent：getX、getY、getRawX、getRawY：分別表示相對於當前view左上角xy和相對於當前屏幕的xy;
     * 4、TouchSlop：系统所能识别出的被认为滑动的最小距离；
     * 5、velocityTracker：速度追踪;
     * 6、GestureDetector：手势检测;
     *
     * 二：view的滑动
     * 1、滑动方式：①：通过view本身的scrollTo/scrollBy方法、②：动画、③：改变view的layoutParams;
     * 2、
     */


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    companion object {
        const val TAG = "MyScrollView"
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (getScrollY() == 0 && !canScrollVertically(1)) {
            Log.d(TAG, "dispatchTouchEvent 1111")
        }
        val result = super.dispatchTouchEvent(ev)
        Log.d(TAG, "dispatchTouchEvent action:${ev?.action} result:$result")
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

    override fun requestDisallowInterceptTouchEvent(disallowIntercept:Boolean){
        Log.d(MyListView.TAG, "requestDisallowInterceptTouchEvent :$disallowIntercept")
        super.requestDisallowInterceptTouchEvent(disallowIntercept)
    }
}