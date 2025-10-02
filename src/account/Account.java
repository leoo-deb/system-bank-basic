package account;

public class Account {
    private final String accountNumber;
    private String accountName;
    protected double accountBagage;
    private String accountUsername;
    private String accountPassrword;

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

    public String informationAccoount() {
        return "Nome da conta: " + accountName
                + "\nNumero da conta: " + accountNumber
                + "\nSaldo da conta: " + accountBagage;
    }

    public boolean login(String username, String password) {
        return username.equals(accountUsername) && password.equals(accountPassrword);
    }

    public void createLogin(String createUsernamer, String createPassword) {
        this.accountUsername = createUsernamer;
        this.accountPassrword = createPassword;
        this.accountName = createUsernamer.toUpperCase();
    }
}