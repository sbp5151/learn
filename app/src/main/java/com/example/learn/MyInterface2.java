package com.example.learn;

public @interface MyInterface2 {

    int type() default 0;
    String level() default "info";
    String value() default  "";
}
