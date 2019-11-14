package aca.project.interfaceShow;

import aca.project.core.Brain;
import aca.project.player.Player;
import aca.project.utility.Converter;

import java.util.ArrayList;


public class Gui {
    public static void showHand(Player player) {
        System.out.println();
        System.out.print(player.getName() + " cards is: ");
        ArrayList<Integer> hand = player.getHand().getCards();
        for (Integer card : hand) {
            System.out.print(Converter.face(card) + "  ");
        }
        System.out.println(Brain.calcHandValue(player));
        System.out.println();
    }
}
