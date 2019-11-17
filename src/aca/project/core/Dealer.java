package aca.project.core;

import aca.project.utility.Deck;
import aca.project.utility.Hand;

public class Dealer {
    public static void deal2cards(Hand hand, Deck deck) {
        hand.addCard(deck.deal());
        hand.addCard(deck.deal());
    }

    public static void resetHands(Hand handA, Hand handB) {
        handA.clear();
        handB.clear();
    }

    public static void addCard(Hand hand, Deck deck) {
        hand.addCard(deck.deal());
    }
}
