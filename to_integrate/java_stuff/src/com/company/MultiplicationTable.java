package com.company;

public class MultiplicationTable {
    public static void main(String[] args) {
        String foo="+----";
        int limit=33;
        for(int x = 1; x <= limit; x++) {
            System.out.println(foo.repeat(limit)+"+");
            System.out.print("|");
            for (int y = 1; y <= limit; y++) {
                System.out.printf("%3d |", x*y);
            }
            System.out.println();
        }
        System.out.println(foo.repeat(limit)+"+");
    }
}
