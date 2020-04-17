package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter array length:");
        int count = scanner.nextInt();
        scanner.nextLine();
        int[] array = readIntegers(count);
        findMin(array);

    }

    public static int[] readIntegers(int count) {
        int arrayLength = count;
        int[] intArray = new int[arrayLength];
        boolean isInt;

        System.out.println("Please enter array integer elements: ");
        for (int i = 0; i < arrayLength; i++) {
            while (true) {
                isInt = scanner.hasNextInt();
                if (!isInt) {
                    System.out.println("Please enter a valid integer.");
                    continue;
                }
                intArray[i] = scanner.nextInt();
                scanner.nextLine();
                break;
            }
        }
        scanner.close();
        System.out.println("Array = " + Arrays.toString(intArray));
        return intArray;
    }

    public static void findMin(int[] array) {
        int minElement = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                minElement = array[i];
            } else {
                minElement = array[i - 1];
            }
        }
        System.out.println("Min Element is " + minElement);
    }
}
