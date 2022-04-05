package AncapLibrary.Economy;


import AncapLibrary.Economy.Exceptions.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;

public class Balance {

    private List<AncapWallet> wallets;

    public Balance() {
        this.wallets = new ArrayList<>();
    }

    public Balance(List<AncapWallet> wallets) {
        this.wallets = wallets;
    }

    public Balance(Balance balance) {
        this.wallets = balance.wallets;
    }

    public boolean have(Balance balance) {
        for (AncapWallet wallet : balance.wallets) {
            if (!this.have(wallet)) {
                return false;
            }
        }
        return true;
    }

    public void remove(Balance balance) throws NotEnoughMoneyException {
        for (AncapWallet wallet : balance.wallets) {
            this.remove(wallet);
        }
    }

    public void add(Balance balance) {
        for (AncapWallet wallet : balance.wallets) {
            this.add(wallet);
        }
    }

    public void multiply(double multiplier) {
        for (AncapWallet ancapWallet : this.wallets) {
            ancapWallet.multiply(multiplier);
        }
    }

    public void replace(Balance balance) {
        this.wallets = balance.wallets;
    }

    private boolean have(AncapWallet wallet) {
        for (AncapWallet ancapWallet : this.wallets) {
            if (ancapWallet.have(wallet)) {
                return true;
            }
        }
        return false;
    }

    private void add(AncapWallet wallet) {
        for (AncapWallet ancapWallet : this.wallets) {
            if (ancapWallet.isSameCurrencyWith(wallet)) {
                ancapWallet.add(wallet);
                return;
            }
            this.wallets.add(wallet);
        }
    }

    private void remove(AncapWallet wallet) throws NotEnoughMoneyException {
        for (AncapWallet ancapWallet : this.wallets) {
            if (ancapWallet.getCurrency().equals(wallet.getCurrency())) {
                ancapWallet.remove(wallet);
                return;
            }
            throw new NotEnoughMoneyException();
        }
    }
}
