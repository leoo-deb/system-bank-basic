package account;

import exception.InsufficientBalanceException;

public class WithdrawAccount {
    private Account account;

    public WithdrawAccount(Account account) {
        this.account = account;
    }

    //Metodo em que realiza uma acao de saque
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {

        if (amount > account.getAccountBagage()) {
            throw new InsufficientBalanceException("Insufficient balance.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid value.");
        }

        account.accountBagage -= amount;
    }
}
