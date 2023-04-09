package com.example.jetpack

import android.app.ActivityManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity"
    }

    //    private val mViewModel: MainActivityViewModel by viewModels()
    private val mViewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel.mUserLiveData.observe(this) {
            Log.d(TAG, "observe user map $it")
        }
        mViewModel.uUserNameLiveData.observe(this) {
            Log.d(TAG, "observe name $it")
        }
        mViewModel.mSwitchUserLiveData.observe(this) {
            Log.d(TAG, "observe user switch map $it")
        }

        getSharedPreferences("", MODE_PRIVATE)
    }

    fun loadUser(view: android.view.View) {
//        mViewModel.loadUser()
        printTask()
    }

    fun printTask() {
        val am: ActivityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val rts = am.getRunningTasks(5)
        rts?.let {
            for (rt in it) {
                Log.d(TAG, "print task ${rt.topActivity?.className}")
            }
        }
    }

    fun getUser(view: android.view.View) {
//        mViewModel.getUser("1008")
        findNavController(R.id.my_fragment_action)
    }
}