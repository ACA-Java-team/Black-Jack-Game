package aca.project.core;

import aca.project.player.HumanPlayer;
import aca.project.utility.Bank;

import java.util.Scanner;

class Choices {
    static private Scanner scanner = new Scanner(System.in);

    static void start(HumanPlayer player) {
        System.out.println("Black jack");
        System.out.println();

        System.out.print("Type your name (String): ");
        player.setName(scanner.nextLine());

        System.out.println();
    }

    static int move() {
        System.out.println("Type your move- ");
        System.out.println("1   or   \"add\"     : for add additional card.");
        System.out.println("2   or   \"double\"  : for double your bet.");
        System.out.println("3   or   \"check\"   : for check cards (end round).");
        System.out.println("4   or   \"fold\"    : for instant lose but back 1/2 from your bet.");
        System.out.println();
        System.out.print("Type: ");
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                case "add":
                    return 1;
                case "2":
                case "double":
                    return 2;
                case "3":
                case "check":
                    return 3;
                case "4":
                case "fold":
                    return 4;
                default:
                    break;
            }
        }
    }

    static int betting(Bank bank) {
        System.out.println();
        System.out.print("Bet your money (you have:" + bank.getAccount() + ") : ");
        return bank.bet(scanner.nextInt());
    }


}
