package aca.project.core;


import aca.project.interfaceShow.Gui;
import aca.project.player.BotPlayer;
import aca.project.player.HumanPlayer;
import aca.project.utility.Deck;

import java.io.IOException;

public class Init {
    public static void play() throws IOException, InterruptedException {
        start();
    }

    private static void start() throws IOException, InterruptedException {
        HumanPlayer player = new HumanPlayer();
        BotPlayer bot = new BotPlayer("Bot");
        Deck deck = new Deck();
        Dealer.deal2cards(player.getHand(), deck);
        player.getBank().bet(2);
        Gui.showStats(player);
        boolean isFirstTime = true;
        boolean isGoing = true;
        while (isGoing) {
            switch (Choices.move(isFirstTime)) {
                case 1:
                    Dealer.addCard(player.getHand(), deck);
                    clear();
                    Gui.showStats(player);
                case 2:
                    isGoing = false;
                    break;
                case 3:
                    player.getBank().doubleBet();
                    clear();
                    Gui.showStats(player);
                case 4:
                    player.getBank().fold();
                    clear();
                    isGoing = false;
                    break;
            }
            isFirstTime = false;
        }
    }

    private static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
