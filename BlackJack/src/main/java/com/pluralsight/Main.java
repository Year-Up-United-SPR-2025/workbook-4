package com.pluralsight;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many people are playing today (maximum 2):\n");
        scanner.nextLine();
        System.out.println("Player One what is your name?:\n");
        scanner.nextLine();
        System.out.println("Player two what is your name?:\n");
        scanner.nextLine();


        Deck d = new Deck();
        d.shuffle(); //shuffles the cards

        Hand h1 = new Hand();

        Card c1 = d.deal();

        c1.flip(); //makes sure it's not filled down

//        System.out.println(c1.getSuit());
//        System.out.println(c1.getValue()); //returns face down
        display(c1);
        System.out.println(c1.getPointValue()); //shows how much the card is worth

        Card c2 = d.deal();
        c2.flip();

        display(c2);
        System.out.println(c2.getPointValue()); //shows how much the card is worth

        h1.deal(c1);
        h1.deal(c2);

        System.out.println("-------------------------------");
        System.out.println("Value:" + h1.getValue()); //all the card values together
    }

    public static void display(Card c) {
        if (c.getSuit().equalsIgnoreCase("Hearts")) {
            System.out.println(ColorCodes.RED + c.getValue() + " " + c.getSuit() + ColorCodes.RESET);
        } else if (c.getSuit().equalsIgnoreCase("Diamonds")) {
            System.out.println(ColorCodes.YELLOW + c.getValue() + " " + c.getSuit() + ColorCodes.RESET);
        } else if (c.getSuit().equalsIgnoreCase("Clubs")) {
            System.out.println(ColorCodes.PURPLE + c.getValue() + " " + c.getSuit() + ColorCodes.RESET);
        } else if (c.getSuit().equalsIgnoreCase("Spades")) {
            System.out.println(ColorCodes.BLUE + c.getValue() + " " + c.getSuit() + ColorCodes.RESET);
        } else {
            System.out.println(c.getValue() + " " + c.getSuit());
        }

    }
}