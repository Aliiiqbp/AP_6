package src.Model.Farm;

import src.Controller.Static;

public class Bank {

    private double money;

    public Bank() {
        money = Static.BANK_FIRST_MONEY;
    }

    public double getMoney() {
        return money;
    }

    public void increase(double amount) {
        this.money += amount;
    }

    public void decrease(double amount) {
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
