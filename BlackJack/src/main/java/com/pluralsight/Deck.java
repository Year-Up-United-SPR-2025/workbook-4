package com.pluralsight;

import java.util.ArrayList;

//This class knows about the card class
public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
    }

    public void deal(Card card) {
        this.cards.add(card);
    }

    public int getSize() {
        return this.cards.size();
    }

    public int getValue() {
        int total = 0;
        for (Card c : this.cards) {
            total += c.getPointValue();
        }
        return total;
    }
}
