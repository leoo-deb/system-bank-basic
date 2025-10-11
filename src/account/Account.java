package account;

import java.text.NumberFormat;
import java.util.Locale;

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
    }

    public double getAccountBagage() {
        return accountBagage;
    }

    public String getAccountName() {
        return accountName;
    }

    public String informationAccount() {
        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);

        return "Account name: " + accountName
                + "\nAccount number: " + accountNumber
                + "\nAccount balance: US$ " + nf.format(accountBagage);
    }
}