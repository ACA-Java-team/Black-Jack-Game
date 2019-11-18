package aca.project.core;

import aca.project.interfacesAndAbstractClasses.Player;
import aca.project.player.BotPlayer;
import aca.project.utility.Converter;
import aca.project.utility.Deck;

import java.util.ArrayList;

public class Brain {
    public static int calcHandValue(Player player) {
        ArrayList<Integer> hand = player.getHand().getCards();
        int value = 0;
        for (Integer card : hand) {
            value += Converter.value(card);
        }
        if (value >= 200) {
            return value - (value - value % 100) + 11 + (value / 100 - 1);
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

    static boolean dealerMove(BotPlayer botPlayer, Deck deck) {
        if (Brain.calcHandValue(botPlayer) < 17) {
            Dealer.addCard(botPlayer.getHand(), deck);
            return false;
        }
        return true;
    }

    static int checkContinue(Player player) {
        if (calcHandValue(player) < 21) {
            return 1;
        } else if (calcHandValue(player) > 21) {
            return 0;
        } else {
            return 21;
        }
    }
}
