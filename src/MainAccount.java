import account.Account;
import account.DepositAccount;
import account.LoginAccount;
import account.WithdrawAccount;
import exception.InsufficientBalanceException;
import exception.CredentialAuthenticationException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainAccount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op, op2;
        String exi, accessUsername, accessPassword, createUsername, createPassword;
        Account ac1 = new Account();
        LoginAccount login = new LoginAccount(ac1);
        DepositAccount dep1 = new DepositAccount(ac1);
        WithdrawAccount wit1 = new WithdrawAccount(ac1);

        do {
            System.out.println("""
                        ----------------------
                        [1] Access account
                        [2] Create account
                        [3] Exit
                        ----------------------""");
            System.out.print("Choice an option: ");
            op2 = sc.nextInt();

            switch (op2) {
                case 1:
                    System.out.println("----------------------");
                    System.out.print("Username: ");
                    accessUsername = sc.next();

                    System.out.print("Password: ");
                    accessPassword = sc.next();
                    System.out.println("----------------------");
                    try {
                        login.accessLogin(accessUsername, accessPassword);
                        System.out.println("Login successful!");
                    } catch (CredentialAuthenticationException | NoSuchElementException e) {
                        System.out.println("ERROR: " + e.getMessage());
                        break;
                    }
                    System.out.print("Welcome " + ac1.getAccountName() + " to the Banking System\n");

                    do {
                        System.out.println("""
                        ----------------------
                        [1] Check balance
                        [2] Make deposit
                        [3] Make withdrawal
                        [4] Account information
                        [5] Exit
                        ----------------------""");
                        System.out.print("Choice an option: ");
                        op = sc.nextInt();

                        //Verifica o saldo da conta
                        if (op == 1) {
                            do {
                                System.out.println("The current account balance is: US$ " + ac1.getAccountBagage());
                                System.out.println("To return to the beginning press the key (1).");
                                exi = sc.next();
                            } while (!exi.equals("1"));
                        }

                        //Faz um deposito na conta
                        if (op == 2) {
                            do {
                                System.out.println("Enter the amount to deposit: ");
                                try {
                                    dep1.deposit(sc.nextDouble());
                                    System.out.println("SUCCESS: current account value: US$ " + ac1.getAccountBagage());
                                } catch (IllegalArgumentException e) {
                                    System.out.println("ERROR: " + e.getMessage());
                                }
                                System.out.println("Do you want to make a new deposit? [Y/N]");
                                exi = sc.next().toUpperCase();
                            } while (exi.equals("Y"));
                        }

                        //Faz um saque na conta
                        if (op == 3) {
                            do {
                                System.out.println("Enter the amount to withdraw: ");
                                try {
                                    wit1.withdraw(sc.nextInt());
                                    System.out.println("SUCCESS: current account value: US$ " + ac1.getAccountBagage());
                                } catch (InsufficientBalanceException | IllegalArgumentException e) {
                                    System.out.println("ERROR: " + e.getMessage());
                                }
                                System.out.println("Do you want to make a new withdraw? [Y/N]");
                                exi = sc.next().toUpperCase();
                            } while (exi.equals("Y"));
                        }

                        //Informacoes da conta
                        if (op == 4) {
                            do {
                                System.out.println("----------------------");
                                System.out.println(ac1.informationAccount());
                                System.out.println("To return to the beginning press the key (1).");
                                exi = sc.next();
                            } while (!exi.equals("1"));
                        }
                    } while (op != 5);
                    break;

                case 2:
                    //Verifica se ja tem uma conta criada no "sistema",
                    //verificando se o metodo getAccountName() esta vazio
                    if (ac1.getAccountName().isEmpty()) {
                        System.out.println("----------------------");
                        System.out.print("Create username: ");
                        createUsername = sc.next();

                        System.out.print("Create password: ");
                        createPassword = sc.next();
                        login.createLogin(createUsername, createPassword);

                        System.out.println("Account created successfully!");
                        System.out.println("----------------------");
                        System.out.println(ac1.informationAccount());
                    } else {
                        System.out.println("ERROR: There is already an account created in this system.");
                        break;
                    }
                    break;
            }
        } while (op2 != 3);
    }
}