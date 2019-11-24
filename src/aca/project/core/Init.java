package aca.project.core;


import aca.project.GuiShow.FigletMenu;
import aca.project.GuiShow.Gui;
import aca.project.player.BotPlayer;
import aca.project.player.HumanPlayer;
import aca.project.utility.Deck;

import java.io.IOException;
import java.util.Scanner;

public class Init {
    private static int win = 0;
    private static int lose = 0;
    private static int draw = 0;
    private static boolean hide = true;


    public static void play() throws IOException, InterruptedException {
        clear();
        System.out.println(FigletMenu.getBlackJack());
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.print("Type your name: ");
        String name = scanner.nextLine();
        clear();
        start(name);
    }


    private static void start(String name) throws IOException, InterruptedException {
        HumanPlayer player = new HumanPlayer();
        BotPlayer bot = new BotPlayer("Bot");
        player.setName(name);
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Dealer.resetHands(player.getHand(), bot.getHand());
            String result = round(player, bot, deck);
            switch (result) {
                case "win":
                    win++;
                    Gui.drawMenu(FigletMenu.getWin());
                    break;
                case "lose":
                    lose++;
                    Gui.drawMenu(FigletMenu.getLose());
                    break;
                case "draw":
                    draw++;
                    Gui.drawMenu(FigletMenu.getDraw());
                    break;
            }
            System.out.println();
            if (player.getBank().getAccount() < 2) {
                break;
            }
            System.out.print("Do you want play again? (Y/N): ");
            String continueVar = scanner.nextLine();
            if (continueVar.equals("n") || continueVar.equals("N")) {
                break;
            }
            if (deck.getDeck().size() < 156) {
                deck.deckReset();
            }
            hide = true;
            clear();
        }
        clear();
        Gui.drawMenu(FigletMenu.getResult());
        System.out.println("                     "+player.getName() + " you have: " + player.getBank().getAccount() + " money.");
        System.out.println("                     win = " + win);
        System.out.println("                     lose = " + lose);
        System.out.println("                     draw = " + draw);
    }


    private static String round(HumanPlayer player, BotPlayer bot, Deck deck) throws IOException, InterruptedException {
        Dealer.deal2cards(player.getHand(), deck);
        Dealer.deal2cards(bot.getHand(), deck);
        player.getBank().bet(2);

        Gui.showStats(bot, hide);
        Gui.showStats(player);

        boolean choice = playerMove(player, deck, bot);
        if (!choice) {
            if (Brain.checkContinue(player) == 0) {
                return "lose";
            } else {
                return "fold";
            }
        }


        boolean dealerMove = false;
        while (!dealerMove) {
            hide = false;
            dealerMove = Brain.dealerMove(bot, deck, player);
            clear();
            Gui.showStats(bot, hide);
            Gui.showStats(player);
        }


        if (Brain.calculateHands(player, bot).equals("win")) {
            return "win";
        } else if (Brain.calculateHands(player, bot).equals("lose")) {
            return "lose";
        } else {
            return "draw";
        }

    }


    /**
     * @return true if player can continue or win, false if player already end round
     */
    private static boolean playerMove(HumanPlayer player, Deck deck, BotPlayer bot) throws IOException, InterruptedException {
        boolean firstMove = true;
        if (Brain.calcHandValue(player) == 21) {
            return true;
        }
        while (true) {
            int choice = Choices.move(firstMove);
            firstMove = false;
            if (choice == 1 || choice == 3) {
                Dealer.addCard(player.getHand(), deck);
                if (choice == 3) {
                    player.getBank().doubleBet();
                }
                clear();
                Gui.showStats(bot, hide);
                Gui.showStats(player);
                if (Brain.checkContinue(player) != 1) {
                    return false;
                }
                if (choice == 3) {
                    return true;
                }
            } else if (choice == 2) {
                return true;
            } else if (choice == 4) {
                player.getBank().fold();
                return false;
            }
        }
    }


    private static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
