package account;

public record DepositAccount(Account account) {

    //Metodo em que realiza uma acao de deposito
    public void deposit(double amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid value.");
        }
        account.accountBagage += amount;
    }
}
