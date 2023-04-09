package com.example.learn.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter
import com.example.learn.R
import com.example.learn.aop.MyDispatcher

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

//
//        val listView: ListView = findViewById(R.id.myListView)
//
//        val data = ArrayList<Map<String, String>>()
//        for (i in 0..390) {
//            val map = HashMap<String,String>()
//            map["text"] = "ssss$i"
//            data.add(map)
//        }
//
//        val from = arrayOf("text")
//        val res = intArrayOf(R.id.textview)
//        val adapter = SimpleAdapter(this, data, R.layout.list_item, from, res)
//        listView.adapter = adapter

    }

    fun myclick(view: View) {
        val result = MyDispatcher.execute()
        Log.d(TAG, "execute result: $result")
    }
}