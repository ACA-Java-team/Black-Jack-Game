package aca.project.interfaceShow;

import aca.project.core.Brain;
import aca.project.player.HumanPlayer;
import aca.project.interfacesAndAbstractClasses.Player;
import aca.project.utility.Converter;

import java.util.ArrayList;


public  class Gui {
    private static final String LINE = "--------------------------------------";


    public static void showStats(Player player) {
        showFigletHand(player);
        System.out.println(LINE);
        showHand(player);
        if (!player.getName().equals("Bot")) {
            showBank((HumanPlayer) player);
            showBet((HumanPlayer) player);
        }
        System.out.println(LINE);
    }

    private static void showHand(Player player) {
        System.out.print(player.getName() + " cards is: ");
        ArrayList<Integer> hand = player.getHand().getCards();
        if (!player.getName().equals("Bot")) {
            for (Integer card : hand) {
                System.out.print(Converter.face(card) + "  ");
            }
            System.out.println();
            System.out.println(player.getName() + " hand value is: " + Brain.calcHandValue(player));
        } else {
            System.out.println(Converter.face(hand.get(0)) + "  ?");
        }
    }

    private static void showFigletHand(Player player) {
        if (!player.getName().equals("Bot") || (player.getHand().getCards().size() > 2)) {
            String[][] arr = new String[player.getHand().getCards().size()][FigletCard.getSTRING_COUNT()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Converter.figlet(player.getHand().getCards().get(i));
            }
            figletCards(arr);
        } else if (player.getName().equals("Bot") && player.getHand().getCards().size() == 2) {
            figletCardsBot(Converter.figlet(player.getHand().getCards().get(0)), FigletCard.getCardBack());

        }
    }

    private static void showBank(HumanPlayer player) {
        System.out.println(player.getName() + " bank is: " + player.getBank().getAccount());
    }

    private static void figletCards(String[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (String[] strings : arr) {
                System.out.print(strings[i] + "      ");
            }
            System.out.println();
        }
    }

    private static void figletCardsBot(String[] a, String[] b) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + "      " + b[i]);
        }
    }

    private static void showBet(HumanPlayer player) {
        System.out.println(player.getName() + " bet is: " + player.getBank().getThisMomentBet()+".");
    }
}
