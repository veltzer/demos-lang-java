package com.company;

public class MulTable {
    public static void main(String[] args) {
        int MAX=10;
        int mul_table[][]=new int[MAX][MAX];
        for(int x=0;x<MAX;x++) {
            for (int y = 0; y < MAX; y++) {
                mul_table[x][y]=(x+1)*(y+1);
            }
        }
        for(int x=0;x<MAX;x++) {
            for (int y = 0; y<MAX; y++) {
                System.out.print(mul_table[x][y]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
