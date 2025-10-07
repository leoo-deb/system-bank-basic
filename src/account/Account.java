package account;

public class Account {
    private final String accountNumber;
    protected String accountName;
    protected double accountBagage;
    protected String accountUsername;
    protected String accountPassword;

    private static int NumberID = 1;

    //Construtor Principal
    public Account() {
        this.accountNumber = "000-" + NumberID++;
        this.accountName = "";
        this.accountBagage = 0;
    }

    public double getAccountBagage() {
        return accountBagage;
    }

    public String getAccountName() {
        return accountName;
    }

    public String informationAccount() {
        return "Account name: " + accountName
                + "\nAccount number: " + accountNumber
                + "\nAccount balance: US$ " + accountBagage;
    }
}