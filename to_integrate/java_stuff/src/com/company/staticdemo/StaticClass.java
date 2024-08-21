package com.company.staticdemo;

public class StaticClass {
    /*
    Static can be attached to classes but ONLY to inner classes.
    Static, when attached to inner classes, means that the inner
    class does not have access to the outer class that created it.
    If the inner class is not static then it DOES have access to the
    outer class instance that created it.
     */
    public static class SubClass {

    }
    public static void main(String[] args) {
        StaticClass my_object=new StaticClass();
        // my_object.y
        System.out.println("Hello, World!");
    }
}

