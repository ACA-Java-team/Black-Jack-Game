package aca.project.test;


import aca.project.player.Player;

public class test {
    public static void cheatDeal(int value, int value2, Player player) {
        player.getHand().addCard(value);
        player.getHand().addCard(value2);
    }

    public static void cheatDeal(int value, int value2, int value3, Player player) {
        cheatDeal(value, value2, player);
        player.getHand().addCard(value3);
    }

    public static void cheatDeal(int value, int value2, int value3, int value4, Player player) {
        cheatDeal(value, value2, value3, player);
        player.getHand().addCard(value4);
    }
}
