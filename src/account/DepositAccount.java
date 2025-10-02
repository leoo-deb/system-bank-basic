package account;

public class DepositAccount {
    private Account account;

    public DepositAccount(Account account) {
        this.account = account;
    }

    //Metodo em que realiza uma acao de deposito
    public void deposit(double amount) {
        if (amount > 0) {
            account.accountBagage += amount;
            System.out.println("Deposito realizado com sucesso! Valor atual da conta: R$ " + account.accountBagage);
        } else {
            System.out.println("ERROR: Valor invalido.");
        }
    }
}
