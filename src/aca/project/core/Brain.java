package aca.project.core;

import aca.project.interfacesAndAbstractClasses.Player;
import aca.project.player.BotPlayer;
import aca.project.player.HumanPlayer;
import aca.project.utility.Converter;
import aca.project.utility.Deck;

import java.util.ArrayList;

public class Brain {

    /**
     * Calculate @player hand value
     * 2-10 cards cost 2-10 value
     * J Q K costs 10 value
     * ACE costs 1 or 11
     * @return value
     */
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

    /**
     * Do turn based on value of bot and player hands
     * Dealer always stop taking cards if hes hand value already is 17or+
     * @return true if dealer do all moves or false if dealer need one more move
     */
    static boolean dealerMove(BotPlayer botPlayer, Deck deck, HumanPlayer humanPlayer) {
        int botValue = Brain.calcHandValue(botPlayer);
        int playerValue = Brain.calcHandValue(humanPlayer);
        if (botValue < 17 && playerValue > botValue) {
            Dealer.addCard(botPlayer.getHand(), deck);
            return false;
        }
        return true;
    }

    /**
     * Checking player need to continue game or he is already win/lose
     * @return 1 if continue, 0 if not, 21 if he already have win combination
     */
    static int checkContinue(Player player) {
        if (calcHandValue(player) < 21) {
            return 1;
        } else if (calcHandValue(player) > 21) {
            return 0;
        } else {
            return 21;
        }
    }

    /**
     * Check and calculate hands values
     * @return win/lose/draw
     */
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
