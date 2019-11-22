package aca.project.utility;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Integer> deck;

    public Deck() {
        deckReset();
    }

    public void deckReset() {
        deckReset(6);
    }

    /**
     * Function what create something like a real deck in ArrayList
     * @param deckCount mean how many decks u use in game
     */
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
