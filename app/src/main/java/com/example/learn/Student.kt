package com.example.learn

import android.util.Log

class Student(var grade: Int, var id: Int, sex: String) : Person(sex) {

    fun gotoSchool() {
        Log.d("TAG", "$name goto school,He is $grade grad,student code is $id")
    }

    //无参构造函数
    constructor() : this(1002, 13, "男")

    //一个参数的构造函数
    constructor(id: Int) : this(1002, id, "男")

    //增加一些参数
    constructor(grade: Int, id: Int, height: Int, weigh: Int) : this(grade, id, "男") {}

    init {
        //这里可以做一些初始化的逻辑
        name = "张三"
    }
}