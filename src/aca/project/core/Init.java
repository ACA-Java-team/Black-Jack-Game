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
    }

    private static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
