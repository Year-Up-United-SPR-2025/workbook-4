package com.pluralsight;

import java.util.ArrayList;

//Hand is depending on the Card class
public class Hand {

    private ArrayList<Card> cards;

    public Hand() {
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
