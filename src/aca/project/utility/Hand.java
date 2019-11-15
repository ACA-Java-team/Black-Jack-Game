package aca.project.utility;

import java.util.ArrayList;

public final class Hand {
    private ArrayList<Integer> cards = new ArrayList<>();

    public void addCard(int value) {
        cards.add(value);
    }

    public void clear() {
        cards = new ArrayList<>();
    }

    public ArrayList<Integer> getCards() {
        return cards;
    }


}
