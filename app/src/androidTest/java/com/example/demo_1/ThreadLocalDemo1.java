package com.example.learn;

import android.content.Intent;

import com.example.thread.ThreadPoolUtil;

import java.util.concurrent.Callable;

public class ThreadLocalDemo1 {


    void test(){


        ThreadPoolUtil.INSTANCE.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "";
            }
        });
    }
}
