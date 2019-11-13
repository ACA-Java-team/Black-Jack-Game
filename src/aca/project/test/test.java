package aca.project.test;

import aca.project.interfaceShow.FigletCard;
import aca.project.interfaceShow.Gui;
import aca.project.player.Player;
import aca.project.utility.Deck;
import aca.project.utility.Hand;

public class test {
    public static void init() {
        Player player = new Player();
        Deck deck = new Deck();
        player.hand.addCard(deck.deal());
        player.hand.addCard(deck.deal());
        Gui.showHandCards(player.hand.get(), "Player");
    }

    static void showArr(Hand hand) {
        for (int i = 0; i < hand.get().size(); i++) {
            System.out.print(" " + hand.get().get(i));
        }
    }
}
