package AncapLibrary.Economy.Exceptions;

import AncapLibrary.Economy.AncapWallet;

public class WalletIncompatibleException extends RuntimeException {

    private AncapWallet firstWallet;
    private AncapWallet secondWallet;

    public WalletIncompatibleException(AncapWallet firstWallet, AncapWallet secondWallet) {
        this.firstWallet = firstWallet;
        this.secondWallet = secondWallet;
    }

    public AncapWallet getFirstWallet() {
        return firstWallet;
    }

    public AncapWallet getSecondWallet() {
        return secondWallet;
    }
}
