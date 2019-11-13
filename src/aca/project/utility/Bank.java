package aca.project.utility;

public final class Bank {
    private int bank;

    public int bet(int value) {
        this.bank -= value;
        return value;
    }

    public void win(int value) {
        this.bank += value;
    }

    public Bank(int bank) {
        this.bank = bank;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }
}
