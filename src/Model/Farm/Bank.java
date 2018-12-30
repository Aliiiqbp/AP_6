package src.Model.Farm;

import src.Controller.Static;

public class Bank {

    double money;

    public Bank() {
        money = Static.BANK_FIRST_MONEY;
    }

    public void increase(double amount) {
        this.money += amount;
    }

    public void decrease(double amount) {
        this.money -= amount;
    }
}
