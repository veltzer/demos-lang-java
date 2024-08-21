package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFilePrinter {
    public static void main(String[] args) {
        String filename="/etc/passwd";
        File file=new File(filename);
        Scanner scanner= null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while(scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
