package account;

import exception.CredentialAuthenticationException;

import java.util.NoSuchElementException;

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

    public void login(String username, String password) throws CredentialAuthenticationException, NoSuchElementException {
        if (!(username.equals(accountUsername) && password.equals(accountPassrword))) {
            throw new CredentialAuthenticationException("Username/password incorrect.");
        }

        if (accountUsername.isEmpty() && accountPassrword.isEmpty()) {
            throw new NoSuchElementException("Not account found.");
        }
    }

    public void createLogin(String createUsernamer, String createPassword) {
        this.accountUsername = createUsernamer;
        this.accountPassrword = createPassword;
        this.accountName = createUsernamer.toUpperCase();
    }

    public String informationAccoount() {
        return "Account name: " + accountName
                + "\nAccount number: " + accountNumber
                + "\nAccount balance: US$ " + accountBagage;
    }
}