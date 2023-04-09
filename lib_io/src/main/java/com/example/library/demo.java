package com.example.library;

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;


class Person{}
class Student extends Person{}
class Teacher extends Person{}
public class demo {

    public void test(){


        List ls = new ArrayList<Person>();
        ls.add(new Student());
    }
}