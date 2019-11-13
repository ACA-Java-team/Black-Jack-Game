package aca.project.interfaceShow;

import aca.project.utility.Converter;

import java.util.ArrayList;

public class Gui {
    public static void showFigletCards(String[] a, String[] b) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+"     "+b[i]);
        }
    }

    public static void showFigletCards(String[] a, String[] b, String[] c) {
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]+"     "+b[i]+"     "+c[i]);
        }
    }

    public static void showHandCards(ArrayList list, String player) {
        System.out.print(player+" cards: ");
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(Converter.face((Integer) list.get(i))+ ", ");
        }
        System.out.print(list.get(list.size()-1)+".");
    }
}
