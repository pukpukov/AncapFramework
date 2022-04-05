package AncapLibrary.Library;

import AncapLibrary.Economy.Balance;
import AncapLibrary.Economy.Exceptions.NotEnoughMoneyException;

public interface BalanceHolder extends AncapObject {

    Balance getBalance();

    void setBalance(Balance balance);

    default void transferMoney(BalanceHolder recipient, Balance balance) throws NotEnoughMoneyException {
        Balance nationBalance = this.getBalance();
        Balance recipientBalance = recipient.getBalance();
        nationBalance.remove(balance);
        recipientBalance.add(balance);
        this.setBalance(nationBalance);
        recipient.setBalance(balance);
    }
}
