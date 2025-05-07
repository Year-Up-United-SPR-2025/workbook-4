package com.pluralsight;


public class Main {
    public static void main(String[] args) {

        Deck d = new Deck();
        d.shuffle(); //shuffles the cards 

        Hand h1 = new Hand();

        Card c1 = d.deal();

        c1.flip(); //makes sure it's not filled down

        System.out.println(c1.getSuit());
        System.out.println(c1.getValue()); //returns face down

    }
}