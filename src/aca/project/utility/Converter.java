package aca.project.utility;

import aca.project.interfaceShow.FigletCard;

public final class Converter {
    public static String[] figlet(int value) {
        switch (value) {
            case 1:
                return FigletCard.getCardA();
            case 2:
                return FigletCard.getCard2();
            case 3:
                return FigletCard.getCard3();
            case 4:
                return FigletCard.getCard4();
            case 5:
                return FigletCard.getCard5();
            case 6:
                return FigletCard.getCard6();
            case 7:
                return FigletCard.getCard7();
            case 8:
                return FigletCard.getCard8();
            case 9:
                return FigletCard.getCard9();
            case 10:
                return FigletCard.getCard10();
            case 11:
                return FigletCard.getCardJ();
            case 12:
                return FigletCard.getCardQ();
            default:
                return FigletCard.getCardK();
        }
    }

    public static int value(int value) {
        switch (value) {
            case 10:
            case 11:
            case 12:
            case 13:
                return 10;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            default: //value = 1 (ace)
                return 100;
        }
    }

    public static String face(int value) {
        switch (value) {
            case 1:
                return "A";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "J";
            case 12:
                return "Q";
            default:
                return "K";
        }
    }
}
