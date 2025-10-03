package account;

public class WithdrawAccount {
    private Account account;

    public WithdrawAccount(Account account) {
        this.account = account;
    }

    //Metodo em que realiza uma acao de saque
    public void withdraw(double amount) {
        if (account.getAccountBagage() == 0) {
            System.out.println("ERROR: A conta nao possui saldo.");
            return;
        }

        if (amount > account.getAccountBagage()) {
            System.out.println("ERROR: A conta nao possui saldo suficiente para realizacao do saque.");
            return;
        }

        if (amount <= 0) {
            System.out.println("ERROR: Valor invalido.");
            return;
        }

        System.out.println("SUCCESS: Valor atual da conta: R$ " + account.getAccountBagage());
        account.accountBagage -= amount;
    }
}
