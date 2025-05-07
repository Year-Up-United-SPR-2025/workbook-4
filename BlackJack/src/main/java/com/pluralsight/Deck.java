package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;

//This class knows about the card class
public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String value : values) {
                //prevents you from making many lines
                //creates card.
                Card c = new Card(suit, value); //4*13

                //adding it to this deck.
                cards.add(c);
            }
        }
    }

    public void shuffle() {
        //Collections.shuffle:
        // Randomly permutes the specified list using a default source of randomness.
        // All permutations occur with approximately equal likelihood
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.size() > 0) {
            Card c = cards.remove(0);
            return c;
        } else {
            return null;
        }
    }

    public int getSize() {
        return cards.size();
    }


}
