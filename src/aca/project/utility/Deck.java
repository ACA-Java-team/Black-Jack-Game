package aca.project.utility;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Integer> deck;

    public Deck() {
        deckReset();
    }

    public Deck(int deckCount) {
        deckReset(deckCount);
    }

    private void deckReset() {
        deckReset(6);
    }

    private void deckReset(int deckCount) {
        this.deck = new ArrayList<>();
        for (int i = 0; i < deckCount; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 1; k <= 13; k++) {
                    deck.add(k);
                }
            }
        }
        Collections.shuffle(deck);
    }

    public int deal() {
        int temp = this.deck.get(this.deck.size() - 1);
        this.deck.remove(this.deck.size() - 1);
        return temp;
    }

    public ArrayList<Integer> getDeck() {
        return deck;
    }
}
