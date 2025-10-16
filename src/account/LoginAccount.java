package account;

import exception.CredentialAuthenticationException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class LoginAccount {
    private final Account account;
    public Scanner sc = new Scanner(System.in);

    public LoginAccount(Account account) {
        this.account = account;
    }

    //Metodo que acessa a conta
    public boolean accessLogin() {
        System.out.println("----------------------");
        System.out.print("Username: ");
        String accessUsername = sc.next();

        System.out.print("Password: ");
        String accessPassword = sc.next();
        System.out.println("----------------------");
        sc.nextLine();

        try {
            account.accessLogin(accessUsername, accessPassword);
            System.out.println("Login successful!");
            System.out.println("Welcome " + account.getAccountName() + " to the Banking System");
        } catch (CredentialAuthenticationException | NoSuchElementException e) {
            System.out.println("ERROR: " + e.getMessage());
            return true;
        }
        return false;
    }

    //Metodo que cria uma conta
    public boolean createLogin() {
        System.out.println("----------------------");
        System.out.print("Create name: ");
        String createName = sc.nextLine();

        System.out.print("Create username: ");
        String createUsername = sc.next();

        System.out.print("Create password: ");
        String createPassword = sc.next();
        sc.nextLine();

        do {
            System.out.print("Confirm password: ");
            String confirmPassword = sc.next();
            sc.nextLine();

            if (confirmPassword.equals(createPassword)) {
                break;
            }
            System.out.println("The password entered must match the one created.");
        } while (true);
        System.out.println("----------------------");

        try {
            account.createLogin(createUsername, createPassword, createName);
            System.out.println("Account created successfully!");
            System.out.println("----------------------");
            System.out.println(account.informationAccount());
        } catch (CredentialAuthenticationException e) {
            System.out.println("ERROR: " + e.getMessage());
            return true;
        }
        return false;
    }
}
