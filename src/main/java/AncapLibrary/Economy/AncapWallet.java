package AncapLibrary.Economy;

import AncapLibrary.Economy.Exceptions.WalletIncompatibleException;

public class AncapWallet {

    private AncapCurrency currency;
    private double amount;

    public AncapWallet (AncapCurrency currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public void add(AncapWallet wallet) {
        this.checkCompatibilityWith(wallet);
        this.add(wallet.amount);
    }

    public void remove(AncapWallet wallet) {
        this.checkCompatibilityWith(wallet);
        this.remove(wallet.amount);
    }

    public void multiply(double amount) {
        this.amount = this.amount*amount;
    }

    public AncapCurrency getCurrency() {
        return currency;
    }

    public double getAmount() {
        return amount;
    }

    public boolean have(AncapWallet wallet) {
        if (!this.currency.equals(wallet.getCurrency())) {
            return false;
        }
        return this.have(wallet.getAmount());
    }

    public boolean isSameCurrencyWith(AncapWallet wallet) {
        return wallet.getCurrency().equals(this.currency);
    }

    private void checkCompatibilityWith(AncapWallet wallet) {
        if (!wallet.isSameCurrencyWith(this)) {
            throw new WalletIncompatibleException(this, wallet);
        }
    }

    private void add(double amount) {
        this.amount = this.amount + amount;
    }

    private void remove(double amount) {
        this.amount = this.amount - amount;
    }

    private boolean have(double amount) {
        return this.amount >= amount;
    }
}
