package com.pluralsight;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Prefix (e.g., Mr., Dr.) or press Enter to skip: ");
        String prefix = scanner.nextLine().trim();

        System.out.print("Enter First Name (required): ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter Middle Name or press Enter to skip: ");
        String middleName = scanner.nextLine().trim();

        System.out.print("Enter Last Name (required): ");
        String lastName = scanner.nextLine().trim();

        System.out.print("Enter Suffix (e.g., Jr., PhD) or press Enter to skip: ");
        String suffix = scanner.nextLine().trim();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            System.out.println("First Name and Last Name are required.");
        } else {
            String formattedName = NameFormatter.formatName(prefix, firstName, middleName, lastName, suffix);
            System.out.println("Formatted Name: " + formattedName);
        }

        scanner.close();
    }
}