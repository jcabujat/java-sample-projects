package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length of array: ");
        boolean isInt = scanner.hasNextInt();
        if (!isInt) {
            System.out.println("Invalid array length. Terminating the program now... ");
            System.exit(0);
        }
        int arrayLength = scanner.nextInt();
        int[] intArray = new int[arrayLength];


        System.out.println("Please enter array integer elements: ");
        for (int i = 0; i < arrayLength; i++) {
            while (true) {
                scanner.nextLine();
                isInt = scanner.hasNextInt();
                if (!isInt) {
                    System.out.println("Please enter a valid integer.");
                    continue;
                }
                intArray[i] = scanner.nextInt();
                break;
            }
        }

        int temp = 0;
        for (int i = 1; i < arrayLength; i++) {
            for (int j = i; j > 0; j--) {
                if (intArray[j] > intArray [j - 1]) {
                    temp = intArray[j];
                    intArray[j] = intArray[j - 1];
                    intArray[j - 1] = temp;
                }
            }
        }
        System.out.println("Array (descending order) = " + Arrays.toString(intArray));


    }
}
