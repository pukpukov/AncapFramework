package AncapLibrary.Player;

import AncapLibrary.Economy.Balance;
import AncapLibrary.Library.BalanceHolder;

public class AncapPlayer implements BalanceHolder {

    private String name;
    private Balance balance;

    public AncapPlayer(String name) {
        this.name = name;
        this.balance = new Balance();
    }

    @Override
    public Balance getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public String getName() {
        return this.name;
    }
}
