package account;

public class WithdrawAccount {
    private Account account;

    public WithdrawAccount(Account account) {
        this.account = account;
    }

    //Metodo em que realiza uma acao de saque
    public void withdraw(double amount) {
        if (amount > 0) {
            account.accountBagage -= amount;
            System.out.println("Saque realizado com sucesso! Valor atual da conta: R$ " + account.accountBagage);
        } else {
            System.out.println("ERROR: Valor invalido.");
        }
    }
}
