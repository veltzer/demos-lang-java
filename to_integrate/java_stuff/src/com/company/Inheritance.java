package com.company;

import java.util.Date;

public class Inheritance {

    // parent class
    static class Employee {
        protected String name;
        protected int salary;
        public Employee(String iname, int isalary) {
            name=iname;
            salary=isalary;
        }
        public void print_me() {
            System.out.println("my name is "+name);
            System.out.println("my salary is "+salary);
        }
        public int get_salary(){
            return salary;
        }
    }

    // child class
    static class Manager extends Employee {
        private int bonus;
        public Manager(String iname, int isalary, int ibonus) {
            super(iname, isalary);
            bonus= ibonus;
        }
        public void print_me() {
            super.print_me();
            //System.out.println("my name is "+name);
            //System.out.println("my salary is "+salary);
            System.out.println("my bonus is "+bonus);
        }
        public int get_salary(){
            return salary+bonus;
        }
        public void make_bonus_bigger() {
            bonus+=bonus;
        }
    }
    static class Factory {
        private Employee[] employees;
        public Factory() {
            Employee mark=new Employee("Mark", 7);
            Manager shay=new Manager("Shay", 100, 20);
            employees=new Employee[2];
            employees[0]=mark;
            employees[1]=shay;
        }
        public int all_salaries() {
            int sum=0;
            for(int i=0;i<employees.length;i++) {
                sum+=employees[i].get_salary();
            }
            return sum;
        }
    }

    static public void main(String[] args) {
        //Factory factory=new Factory();
        //System.out.println("sum of all salaries is "+factory.all_salaries());
        Manager m = new Manager("shay", 100, 20);
        m.print_me();
        //System.out.println("my type is "+m.getClass().getName());
        //Employee e=m;
        //System.out.println("my type is "+e.getClass().getName());
    }
}
