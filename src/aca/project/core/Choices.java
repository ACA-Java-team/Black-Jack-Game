package aca.project.core;


import java.util.Scanner;

class Choices {
    static private Scanner scanner = new Scanner(System.in);


    static int move(Boolean isFirstTime) {
        System.out.println("Type your move- ");
        System.out.println("   1   or   \"add\"     : for take one more card.");
        System.out.println("   2   or   \"check\"   : for check cards (end round).");
        if (isFirstTime) {
            System.out.println("   3   or   \"double\"  : for double your bet and take only one card.");
            System.out.println("   4   or   \"fold\"    : for instant lose but back 50% from your bet.");
        }
        System.out.println();
        System.out.print("Type: ");
        while (true) {
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                case "add":
                    return 1;
                case "2":
                case "check":
                    return 2;
                case "3":
                case "double":
                    if (isFirstTime) {
                        return 3;
                    } else {
                        break;
                    }
                case "4":
                case "fold":
                    if (isFirstTime) {
                        return 4;
                    } else {
                        break;
                    }
                default:
                    break;
            }
        }
    }

}
