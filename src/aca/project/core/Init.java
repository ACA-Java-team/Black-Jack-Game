package aca.project.core;


import aca.project.interfaceShow.Gui;
import aca.project.player.Player;
import aca.project.utility.Deck;

public class Init {
    public static void start() {
        Player player = new Player(2200, "Player");
        Player bot = new Player(2200, "Bot");
        Deck deck = new Deck();

        Dealer.deal2cards(player.getHand(), deck);
        Dealer.deal2cards(bot.getHand(), deck);



        Gui.showFigletHand(bot);
        Gui.showHand(bot);

        Gui.showFigletHand(player);
        Gui.showHand(player);
    }
}
