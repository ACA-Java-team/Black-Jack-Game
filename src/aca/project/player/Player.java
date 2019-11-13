package aca.project.player;

import aca.project.utility.Bank;
import aca.project.utility.Hand;


public class Player {
    public Bank bank;
    public Hand hand;

    public Player() {
        this.bank = new Bank(2200);
        this.hand = new Hand();
    }

    public Player(int value) {
        this.bank = new Bank(value);
        this.hand = new Hand();
    }
}
