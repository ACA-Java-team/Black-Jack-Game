package aca.project.utility;

import java.util.ArrayList;

public final class Hand {
    private ArrayList<Integer> hand = new ArrayList<>();

    public void addCard(int value) {
        hand.add(value);
    }

    public void clear() {
        hand = new ArrayList<>();
    }

    public ArrayList<Integer> get() {
        return hand;
    }
}
