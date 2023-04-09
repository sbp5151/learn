package com.example.learn

import android.util.Log
import java.security.PrivateKey

open class Person(var sex: String) {

    var name = ""
    var age = 0

    val sk:PrivateKey? = null

    fun sleep() {
        Log.d("TAG", "$name is sleep,He is $age years old,sex :$sex")
    }
}