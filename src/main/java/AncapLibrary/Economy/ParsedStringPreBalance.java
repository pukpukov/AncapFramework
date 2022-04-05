package AncapLibrary.Economy;

import AncapLibrary.StringParser.ParsedString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ParsedStringPreBalance {

    private ParsedString string;

    public ParsedStringPreBalance(ParsedString string) {
        this.string = string;
    }

    public Balance getPreparedBalance() {
        Set<String> currencyNames = string.getKeys();
        List<AncapWallet> wallets = new ArrayList<>();
        for (String currencyName : currencyNames) {
            AncapCurrency currency = new AncapCurrency(currencyName);
            double amount = this.getCurrencyAmount(currencyName);
            AncapWallet wallet = new AncapWallet(currency, amount);
            wallets.add(wallet);
        }
        return new Balance(wallets);
    }

    private Double getCurrencyAmount(String type) {
        double amount;
        try {
            amount = Double.parseDouble(this.string.getValue(type));
        } catch (NumberFormatException | NullPointerException e) {
            return 0D;
        }
        return amount;
    }
}
