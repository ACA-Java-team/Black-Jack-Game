package aca.project.player;

import aca.project.interfacesAndAbstractClasses.Human;
import aca.project.interfacesAndAbstractClasses.Player;
import aca.project.utility.Bank;

public class HumanPlayer extends Player implements Human {

    public HumanPlayer() {
        super("Player");
    }

    @Override
    public Bank getBank() {
        return this.bank;
    }
}
