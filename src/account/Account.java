package account;

import exception.CredentialAuthenticationException;
import exception.InsufficientBalanceException;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.NoSuchElementException;

public class Account {
    private final String accountNumber;
    private String accountName;
    private double accountBagage;
    private String accountUsername;
    private String accountPassword;

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

    //Verificacao para realizar deposito
    public void depositAccount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid value.");
        }
        accountBagage += amount;
    }

    //Verificacao para realizar saque
    public void withdrawAccount(double amount) throws InsufficientBalanceException {
        if (amount > accountBagage) {
            throw new InsufficientBalanceException("The account does not have sufficient funds.");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid value.");
        }
        accountBagage -= amount;
    }

    //Validacoes para acessar a conta
    public void accessLogin(String username, String password) throws CredentialAuthenticationException {
        //Verifica se caso ainda nao ha nenhuma conta criada
        if (accountUsername == null | accountPassword == null) {
            throw new NoSuchElementException("Not account found.");
        }
        //Caso ja tenha uma conta criada sera feita a verificacao
        //do usuario e senha estao de acordo com o digitadd
        if (!(username.equals(accountUsername) && password.equals(accountPassword))) {
            throw new CredentialAuthenticationException("Username/password incorrect.");
        }
    }

    //Validacoes para criar a conta
    public void createLogin(String createUsername, String createPassword, String createName) throws CredentialAuthenticationException {
        //Verifica se possui uma conta ja criada no sistema
        if (accountUsername != null) {
            throw new CredentialAuthenticationException("There is already an account created in this system");
        }

        //Regex de validacao para a criacao do nome
        if (!createName.matches("^[a-zA-Z\\s]{3,16}$")) {
            throw new CredentialAuthenticationException("The name must contain at least 3 characters and a maximum of 16 characters.");
        }

        //Regex de validacao para a criacao da senha
        if (!createPassword.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$")) {
            throw new CredentialAuthenticationException("""
                    The password must contain at least:
                    - at least 8 characters;
                    - 1 uppercase character;
                    - 1 lowercase character;
                    - 1 special character;
                    - 1 number.""");
        }

        this.accountUsername = createUsername;
        this.accountPassword = createPassword;
        this.accountName = createName.toUpperCase();

    }

    public String informationAccount() {
        Locale locale = Locale.ENGLISH;
        NumberFormat nf = NumberFormat.getNumberInstance(locale);

        return "Account name: " + accountName
                + "\nAccount number: " + accountNumber
                + "\nAccount balance: US$ " + nf.format(accountBagage);
    }
}