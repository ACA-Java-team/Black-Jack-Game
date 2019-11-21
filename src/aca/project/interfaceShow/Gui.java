package aca.project.interfaceShow;

import aca.project.core.Brain;
import aca.project.interfacesAndAbstractClasses.Player;
import aca.project.player.BotPlayer;
import aca.project.player.HumanPlayer;
import aca.project.utility.Converter;

import java.util.ArrayList;

public class Gui {
    private static final String LINE = "--------------------------------------";

    public static void showStats(HumanPlayer player) {
        System.out.println(LINE);
        showFigletHand(player, false);
        System.out.println(LINE);
        showHand(player, false);
        showHandValue(player, false);
        System.out.println(LINE);
        showBank(player);
        showBet(player);
        System.out.println(LINE);
    }


    public static void showStats(BotPlayer bot, boolean hide) {
        System.out.println(LINE);
        showFigletHand(bot, hide);
        System.out.println(LINE);
        showHand(bot, hide);
        showHandValue(bot, hide);
        System.out.println(LINE);
    }

    private static void showFigletHand(Player player, boolean hide) {
        if (hide) {
            figletCards(Converter.figlet(player.getHand().getCards().get(0)));
        } else {
            String[][] tempArr = new String
                    [player.getHand().getCards().size()]
                    [FigletCard.getSTRING_COUNT()];
            for (int i = 0; i < tempArr.length; i++) {
                tempArr[i] = Converter.figlet(player.getHand().getCards().get(i));
            }
            figletCards(tempArr);
        }
    }

    private static void showHandValue(Player player, boolean hide) {
        if (hide) {
            System.out.println(player.getName() + " hand value is: ?");
        } else {
            System.out.println(player.getName() + " hand value is: " + Brain.calcHandValue(player));
        }
    }


    private static void showHand(Player player, boolean hide) {
        ArrayList<Integer> hand = player.getHand().getCards();
        System.out.print(player.getName() + " cards is: ");
        if (hide) {
            System.out.println(Converter.face(hand.get(0)) + "  ?");
        } else {
            for (Integer card : hand) {
                System.out.print(Converter.face(card) + "  ");
            }
            System.out.println();
        }
    }


    private static void showBank(HumanPlayer player) {
        System.out.println(player.getName() + " bank is: " + player.getBank().getAccount());
    }

    private static void figletCards(String[][] arr) {
        System.out.println();
        for (int i = 0; i < arr[0].length; i++) {
            for (String[] strings : arr) {
                System.out.print(strings[i] + "      ");
            }
            System.out.println();
        }
    }

    private static void figletCards(String[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "      " + FigletCard.getCardBack()[i]);
        }
    }

    public static void drawMenu(String[] arr) {
        System.out.println();
        for (String string : arr) {
            System.out.println(string);
        }
    }

    private static void showBet(HumanPlayer player) {
        System.out.println(player.getName() + " bet is: " + player.getBank().getThisMomentBet() + ".");
    }
}
