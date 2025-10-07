package account;

import exception.InsufficientBalanceException;

public record WithdrawAccount(Account account) {

    //Metodo em que realiza uma acao de saque
    public void withdraw(double amount) throws InsufficientBalanceException, IllegalArgumentException {

        if (amount > account.getAccountBagage()) {
            throw new InsufficientBalanceException("The account does not have sufficient funds.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid value.");
        }

        account.accountBagage -= amount;
    }
}
