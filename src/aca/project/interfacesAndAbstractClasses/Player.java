package aca.project.interfacesAndAbstractClasses;

import aca.project.utility.Bank;
import aca.project.utility.Hand;


public abstract class Player {
    private String name;
    private Hand hand;


    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }


    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }
}
