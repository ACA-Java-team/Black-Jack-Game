package aca.project.core;


import aca.project.interfaceShow.FigletMenu;
import aca.project.interfaceShow.Gui;
import aca.project.player.BotPlayer;
import aca.project.player.HumanPlayer;
import aca.project.utility.Deck;

import java.io.IOException;
import java.util.Scanner;

public class Init {
    private static int win = 0;
    private static int lose = 0;
    private static int draw = 0;

    public static void play() throws IOException, InterruptedException {
        clear();
        start();
    }

    private static void start() throws IOException, InterruptedException {
        HumanPlayer player = new HumanPlayer();
        BotPlayer bot = new BotPlayer("Bot");
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
            System.out.print("Do you want play again?: ");
            String continueVar = scanner.nextLine();
            if (continueVar.equals("n") || continueVar.equals("N")) {
                break;
            }
            clear();
        }
        Gui.drawMenu(FigletMenu.getResult());
        System.out.println(player.getName() + " you have: " + player.getBank().getAccount() + " money.");
        System.out.println("win = " + win);
        System.out.println("lose = " + lose);
        System.out.println("draw = " + draw);
    }


    private static String round(HumanPlayer player, BotPlayer bot, Deck deck) throws IOException, InterruptedException {
        Dealer.deal2cards(player.getHand(), deck);
        Dealer.deal2cards(bot.getHand(), deck);

        player.getBank().bet(2);

        Gui.showStats(bot);
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
            dealerMove = Brain.dealerMove(bot, deck);
            clear();
            Gui.showStats(bot);
            Gui.showStats(player);
        }
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
                Gui.showStats(bot);
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
