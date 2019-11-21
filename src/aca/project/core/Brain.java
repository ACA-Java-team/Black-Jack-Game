package aca.project.core;

import aca.project.interfacesAndAbstractClasses.Player;
import aca.project.player.BotPlayer;
import aca.project.player.HumanPlayer;
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

    static boolean dealerMove(BotPlayer botPlayer, Deck deck, HumanPlayer humanPlayer) {
        int botValue = Brain.calcHandValue(botPlayer);
        int playerValue = Brain.calcHandValue(humanPlayer);
        if (botValue < 17 && playerValue > botValue) {
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

    static String calculateHands(HumanPlayer player, BotPlayer bot) {
        int playerValue = Brain.calcHandValue(player);
        int botValue = Brain.calcHandValue(bot);

        if (botValue > 21) {
            player.getBank().win();
            return "win";
        }
        if ((playerValue == botValue) && playerValue == 21) {
            player.getBank().draw();
            return "draw";
        }

        if (playerValue == 21) {
            player.getBank().win();
            return "win";
        } else if (botValue == 21) {
            player.getBank().lose();
            return "lose";
        }

        if (playerValue > botValue) {
            player.getBank().win();
            return "win";
        } else if (playerValue < botValue) {
            player.getBank().lose();
            return "lose";
        }

        player.getBank().draw();
        return "draw";
    }
}
