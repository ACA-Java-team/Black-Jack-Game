package aca.project.core;

import aca.project.player.Player;
import aca.project.utility.Bank;

import java.util.Scanner;

class Choices {
    static private Scanner scanner = new Scanner(System.in);

    static void start(Player player) {
        System.out.println("Black jack");
        System.out.println();

        System.out.print("Type your name (String): ");
        player.setName(scanner.nextLine());

        System.out.println();

        System.out.print("Type your bank (int): ");
        player.getBank().setBank(scanner.nextInt());
        System.out.println();
    }

    static int move() {
        System.out.println("Type your move- ");
        System.out.println("1   or   \"add\"     : for add additional card.");
        System.out.println("2   or   \"double\"  : for double your bet.");
        System.out.println("3   or   \"check\"   : for check cards (end round).");
        System.out.println("4   or   \"fold\"    : for instant lose but back 1/2 to your bet.");
        while (true) {
            System.out.println();
            System.out.print("Type: ");
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
                    System.out.println("Error - type again.");
                    break;
            }
        }
    }

    static void betting(Bank bank) {
        System.out.println("Bet your money (you have:" + bank.getAccount() + ") : ");
        bank.bet(scanner.nextInt());
    }


}
