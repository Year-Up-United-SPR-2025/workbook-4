package com.pluralsight;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Room Input
        System.out.println("Enter thge number of beds in the room: \n");
        int beds = scanner.nextInt();

        System.out.println("Enter the price of the rooms: \n");
        double price = scanner.nextDouble();

        System.out.println();

    }
}