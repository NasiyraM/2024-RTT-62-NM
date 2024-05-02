package org.example;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scl = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num1 = scl.nextInt();

        System.out.print("My name is " + num1);
    }
}
