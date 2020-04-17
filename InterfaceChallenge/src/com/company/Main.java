package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Player player1 = new Player("Jo", 100, 80, "Lance");
        System.out.println(player1);
        player1.setHitPoints(120);
        player1.setPower(100);
        saveObject(player1);
        Player player2 = new Player("Aiza", 100, 60, "Wand");
        loadObject(player2);
        player1.setPlayerName("MasterJo");
        player2.setWeapon("Yantok");
        saveObject(player2);

        Monster monster1 = new Monster("Cookie monster",50,30);
        saveObject(monster1);
        System.out.println(monster1);
        loadObject(monster1);
        saveObject(monster1);
        monster1.setHitPoints(200);
        monster1.setPower(120);
        monster1.setMonsterName("Frankenstein");
        saveObject(monster1);

    }

    public static void saveObject(ISaveable object) {
        System.out.println("Saving object....");
        for (int i = 0; i < object.write().size(); i++) {
            System.out.println("Saving value " + object.write().get(i) + " to storage device");
        }
        System.out.println("=======================");
    }

    public static void loadObject(ISaveable object) {
        ArrayList<String> attributes = readValues();
        object.read(attributes);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("============\nChoose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid option. (1 or 0 only)");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string "+ "(" + (index+1) + "): ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
                default:
                    System.out.println("Invalid option. (1 or 0 only)");
                    break;
            }
        }
        return values;
    }
}
