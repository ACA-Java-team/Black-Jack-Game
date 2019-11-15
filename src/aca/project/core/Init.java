package aca.project.core;


import aca.project.interfaceShow.Gui;
import aca.project.player.Player;
import aca.project.utility.Deck;

import java.io.IOException;
import java.util.Scanner;

public class Init {
    public static void play() throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Black Jack game");
        System.out.println();

        System.out.print("Type your name: ");
        String name = scanner.nextLine();
        System.out.println();

        System.out.print("Set your bank money (default: 22): ");
        int bank = scanner.nextInt();
        System.out.println();

        clear();

        start(name, bank);

        /*System.out.println("Type: add - for adding card.");
        System.out.println("Type: stop - for end dealer.");
        System.out.println("Type: double - for double bet.");*/
    }

    public static void start(String name, int bank) {
        Scanner scanner = new Scanner(System.in);
        Player player = new Player(name, bank);
        Player bot = new Player("Bot", 22);
        Deck deck = new Deck();

        System.out.println();
        System.out.print("Type your bet: ");
        int betMoney = scanner.nextInt();
        while (betMoney < 1 || betMoney > player.getBank().getBank()) {
            if (betMoney < 1) {
                betMoney = 1;
            } else if (betMoney > player.getBank().getBank()) {
                System.out.println("Error: try again.");
                betMoney = scanner.nextInt();
            }
        }
        player.getBank().bet(betMoney);


        Dealer.deal2cards(player.getHand(), deck);
        Dealer.deal2cards(bot.getHand(), deck);

        Gui.showStats(bot);
        Gui.showStats(player);
    }

    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
