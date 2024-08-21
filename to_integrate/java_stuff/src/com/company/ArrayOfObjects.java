package com.company;

public class ArrayOfObjects {
    public static class Student {
        public String name;
        public String surname;
        //....
        public Student(String name, String surname) {
            this.name=name;
            this.surname=surname;
        }
    }
    public static void main(String[] args) {
        Student[] my_class=new Student[2];
        my_class[0] = new Student("Mark", "Veltzer");
        my_class[1] = new Student("Shay", "Sarid");
        for(int i=0;i<my_class.length; i++) {
            System.out.println("Studnet "+i+" is "+my_class[i]);
        }
    }
}
