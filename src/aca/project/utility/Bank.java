package aca.project.utility;

public class Bank {
    private int bank;
    private int bet = 0;

    public int bet(int value) {
        this.bank -= value;
        this.bet = value;
        return value;
    }

    public void win() {
        this.bank += this.bet*2;
        this.bet = 0;
    }

    public void lose() {
        this.bet = 0;
    }

    public void doubleBet() {
        this.bank -= this.bet;
        this.bet *= 2;
    }

    public void fold() {
        this.bank += this.bet/2;
        this.bet = 0;
    }

    public Bank(int bank) {
        this.bank = bank;
    }

    public int getAccount() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getThisMomentBet() {
        return bet;
    }
}
