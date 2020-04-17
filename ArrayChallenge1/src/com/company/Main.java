package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int size = 0;
        boolean isInt = scanner.hasNextInt();
        if (isInt) {
            size = scanner.nextInt();
        } else {
            System.out.println("Please enter a valid number.");
        }
        int intArray[] = new int[size];

    }
}
