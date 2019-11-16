package aca.project.player;

import aca.project.utility.Bank;
import aca.project.utility.Hand;


public class Player {
    private String name;
    private Bank bank;
    private Hand hand;

    public Player() {
        this.bank = new Bank(2200);
        this.hand = new Hand();
    }

    public Player(String name, int value) {
        this.name = name;
        this.bank = new Bank(value);
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public Bank getBank() {
        return bank;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }
}
