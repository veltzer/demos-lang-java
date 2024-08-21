package com.company;

import java.util.Scanner;

public class StudentsArray {
    public static void main(String[] args) {
        Scanner myInput = new Scanner(System.in);
        System.out.print("What size is your class: ");
        int number_of_students = myInput.nextInt();
        int[] grades = new int[number_of_students];
        for (int i = 0; i < number_of_students; i++) {
            System.out.print("What is the grade of student " + i + ": ");
            int current_grade = myInput.nextInt();
            grades[i] = current_grade; // <-- this is insertion into the array
            // at location i
        }
        System.out.println("Now printing all the grades...");
        for (int i = 0; i < number_of_students; i++) {
            System.out.println("grade of student " + i + " is " + grades[i]);
        }
    }
}
