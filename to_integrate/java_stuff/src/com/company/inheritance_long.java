package com.company;

public class inheritance_long {
    /* these class I write */
    static class A {
        void doit() {
            System.out.println("I am A");
        }
    }
    static class AB extends A {

    }
    static class B extends AB {
        /*
        void doit() {
            System.out.println("I am B");
        }
        */

    }
    /* This class you write */
    static class C extends B {
        void doit() {
            super.doit();
            System.out.println("I am C");
        }
    }
    static public void main(String[] args) {
        C c=new C();
        c.doit();
    }
}
