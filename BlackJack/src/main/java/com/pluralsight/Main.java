package com.pluralsight;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner playerScanner = new Scanner(System.in);

        //--- Welcome to the BLackJack Game
        System.out.println("Welcome to the Game of Blackjack");

        // --- Player 1 ---(True Player YOU)
        System.out.print("Enter name for Player 1: ");
        String player1Name = playerScanner.nextLine();

        // --- Player 2 ---(The House)
        System.out.print("Enter name for Player 2: ");
        String player2Name = playerScanner.nextLine();

        // --- Print the player names ---
        System.out.println("\n--- Player Details ---"); //
        System.out.println("Player 1: " + player1Name);
        System.out.println("Player 2: " + player2Name);


        // -------------------- Player 1(You)
        Deck d = new Deck();
        d.shuffle(); //shuffles the cards

        Hand h1 = new Hand();

        Card c1 = d.deal();
        c1.flip(); //flip card 1
        display(c1);
        System.out.println(c1.getPointValue());

        Card c2 = d.deal();
        c2.flip(); //flip card 2
        display(c2);
        System.out.println(c2.getPointValue());

        h1.deal(c1);
        h1.deal(c2);

        System.out.println(player1Name + " Hand Value: " + h1.getValue());

        // -------------------- Player 2 (The House)
        Deck d2 = new Deck();
        d2.shuffle(); //shuffles the cards

        Hand h2 = new Hand();

        Card c3 = d2.deal();
        c3.flip(); //flip card 1 for player 2
        display(c3);
        System.out.println(c3.getPointValue());

        Card c4 = d2.deal();
        c4.flip(); //flip card 2 for player 2
        display(c4);
        System.out.println(c4.getPointValue());

        h2.deal(c3);
        h2.deal(c4);

        System.out.println(player2Name + " Hand Value: " + h2.getValue());

        // -------------------- Result --------------------
        System.out.println("-------------------------------");
        if (h1.getValue() > h2.getValue()) {
            System.out.println(player1Name + " wins!");
        } else if (h1.getValue() < h2.getValue()) {
            System.out.println(player2Name + " wins!");
        } else {
            System.out.println("It's a tie!");
        }
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