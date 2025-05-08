package com.pluralsight;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner playerScanner = new Scanner(System.in);

        //--- Welcome to the BLackJack Game
        System.out.println("Welcome to the Game of Blackjack");

        // --- Player 1 ---(True Player)
        System.out.print("Enter name for Player 1: ");
        String player1Name = playerScanner.nextLine();

        // --- Player 2 ---(The House)
        System.out.print("Enter name for Player 2: ");
        String player2Name = playerScanner.nextLine();

        // --- Print the player names ---
        System.out.println("\n--- Player Details ---"); //
        System.out.println("Player 1: " + player1Name);
        System.out.println("Player 2: " + player2Name);


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