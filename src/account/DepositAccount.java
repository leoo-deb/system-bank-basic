package account;

public class DepositAccount {
    private Account account;

    public DepositAccount(Account account) {
        this.account = account;
    }

    //Metodo em que realiza uma acao de deposito
    public void deposit(double amount) {

        if (amount < 0) {
            throw new IllegalArgumentException("Invalid value.");
        }
        account.accountBagage += amount;
    }
}
