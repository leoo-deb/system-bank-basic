package account;

import exception.CredentialAuthenticationException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public record LoginAccount(Account account) {
    public static Scanner sc = new Scanner(System.in);

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
