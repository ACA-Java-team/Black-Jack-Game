package aca.project.core;

import aca.project.player.Player;
import aca.project.utility.Converter;

import java.util.ArrayList;

public class Brain {

    //not working properly with 2 aces
    public static int calcHandValue(Player player) {
        ArrayList<Integer> hand = player.getHand().getCards();
        int value = 0;
        for (Integer card : hand) {
            value += Converter.value(card);
        }
        if (value > 200) {
            return 12;
        } else if (value > 100) {
            if (value - 100 + 11 > 21) {
                return value - 100 + 1;
            } else {
                return value - 100 + 11;
            }
        } else {
            return value;
        }
    }
}
