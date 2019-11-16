package aca.project.core;


import aca.project.interfaceShow.Gui;
import aca.project.player.Player;
import aca.project.utility.Deck;

import java.io.IOException;

public class Init {
    public static void play() throws IOException, InterruptedException {
        start();
    }

    private static void start() throws IOException, InterruptedException {
        Player player = new Player();
        Player bot = new Player("Bot", 22);
        Deck deck = new Deck();
        Choices.start(player);
        clear();
        Choices.betting(player.getBank());

        Dealer.deal2cards(player.getHand(), deck);
        Dealer.deal2cards(bot.getHand(), deck);

        Gui.showStats(bot);
        Gui.showStats(player);
        Choices.move();
    }

    private static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
