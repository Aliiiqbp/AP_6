package Model.Farm;

import Controller.Static;

public class Bank {

    private double money;

    public Bank() {
        money = Static.BANK_FIRST_MONEY;
    }

    public void sell(double amount) {
        this.money += amount;
    }

    public void buy(double amount) {
        if (canDecrease(amount)) {
            this.money -= amount;
        }
    }

    public boolean canDecrease(double amount) {
        if (amount <= money) {
            return true;
        }
        return false;
    }
}
