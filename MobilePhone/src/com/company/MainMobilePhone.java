package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("Jo's Phone");

    public static void main(String[] args) {
        System.out.println("Phone starting....");
        printActions();
        boolean quit = false;
        while (!quit) {
            System.out.println("Enter action (6 to list actions):");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    quit = true;
                    break;

                case 1:
                    mobilePhone.printContacts();
                    break;

                case 2:
                    addContact();
                    break;

                case 3:
                    updateContact();
                    break;

                case 4:
                    removeContact();
                    break;

                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;

            }
        }
    }

    private static void addContact() {
        System.out.println("Adding contact...\nEnter name: ");
        String name = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactName(name);
        if (currentContact != null) {
            System.out.println("Contact " + name + " already existing.");
            return;
        }
        System.out.println("Enter contact number: ");
        String number = scanner.nextLine();
        Contact contact = new Contact(name, number);
        System.out.println(name + " - " + number + "\nConfirm to add new contact (Y/N): ");
        String confirm = scanner.nextLine();
        if (confirm.equals("Y") || confirm.equals("y")) {
            if (mobilePhone.addContact(contact)) {
                System.out.println("New contact added.");
            } else {
                System.out.println("Contact " + name + " already exists.");
            }
        } else {
            System.out.println("Contact was not added.");
        }
    }

    private static void updateContact() {
        System.out.println("Updating contact... \nEnter name: ");
        String oldName = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactName(oldName);
        if (currentContact == null) {
            System.out.println("Contact not existing.");
            return;
        } else {
            System.out.println("Current contact details: " + currentContact.getName() + " - " + currentContact.getNumber());
        }
        System.out.println("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact number: ");
        String newNumber = scanner.nextLine();
        Contact updatedContact = new Contact(newName, newNumber);
        System.out.println("Current contact details: " + currentContact.getName() + " - " + currentContact.getNumber());
        System.out.println("Updated contact details: " + updatedContact.getName() + " - " + updatedContact.getNumber());
        System.out.println("Confirm to update contact details (Y/N):");
        String confirm = scanner.nextLine();
        if (confirm.equals("Y") || confirm.equals("y")) {
            if (mobilePhone.updateContact(currentContact, updatedContact)) {
                System.out.println("Contact has been updated.");
            } else {
                System.out.println("Failed to update contact.");
            }
        } else {
            System.out.println("Update action canceled.");
        }
    }

    private static void removeContact() {
        System.out.println("Deleting contact... \nEnter name: ");
        String oldName = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactName(oldName);
        if (currentContact == null) {
            System.out.println("Contact not existing.");
            return;
        } else {
            System.out.println("Current contact details: " + currentContact.getName() + " - " + currentContact.getNumber());
        }
        System.out.println("Confirm to delete(Y/N): ");
        String confirm = scanner.nextLine();
        if (confirm.equals("Y") || confirm.equals("y")) {
            if (mobilePhone.removeContact(currentContact)) {
                System.out.println("Contact successfully deleted.");
            } else {
                System.out.println("Error in deleting contact.");
            }
        } else {
            System.out.println("Delete action canceled.");
        }
    }

    private static void queryContact() {
        System.out.println("Querying contact... \nEnter name: ");
        String oldName = scanner.nextLine();
        Contact currentContact = mobilePhone.findContactName(oldName);
        if (currentContact == null) {
            System.out.println("Contact not existing.");
            return;
        } else {
            System.out.println("Current contact details: " + currentContact.getName() + " - " + currentContact.getNumber());
        }
    }

    private static void printActions() {
        System.out.println("Action List: \n" +
                "0 - Quit\n" +
                "1 - Print contact list\n" +
                "2 - Add contact\n" +
                "3 - Update contact\n" +
                "4 - Remove contact\n" +
                "5 - Find contact\n" +
                "6 - List actions"
        );
    }
}
