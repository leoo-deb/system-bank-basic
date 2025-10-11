import account.*;
import exception.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainAccount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op, op2;
        String exi;
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
            sc.nextLine();

            switch (op2) {

                //Acessa a conta
                case 1:
                    System.out.println("----------------------");
                    System.out.print("Username: ");
                    String accessUsername = sc.next();

                    System.out.print("Password: ");
                    String accessPassword = sc.next();
                    System.out.println("----------------------");
                    try {
                        login.accessLogin(accessUsername, accessPassword);
                        System.out.println("Login successful!");
                    } catch (CredentialAuthenticationException | NoSuchElementException e) {
                        System.out.println("ERROR: " + e.getMessage());
                        break;
                    }

                    System.out.println("Welcome " + ac1.getAccountName() + " to the Banking System");
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
                        sc.nextLine();

                        //Verifica o saldo da conta
                        if (op == 1) {
                            do {
                                System.out.println("The current account balance is: US$ " + ac1.getAccountBagage());
                                System.out.print("To return to the beginning press (ENTER).");
                                exi = sc.nextLine();
                            } while (!exi.isBlank());
                        }

                        //Faz um deposito na conta
                        if (op == 2) {
                            do {
                                System.out.print("Enter the amount to deposit: ");
                                try {
                                    dep1.deposit(sc.nextInt());
                                    System.out.println("SUCCESS: current account value: US$ " + ac1.getAccountBagage());
                                } catch (InputMismatchException e) {
                                    System.out.println("ERROR: Enter numbers only.");
                                    sc.nextLine();
                                } catch (IllegalArgumentException e) {
                                    System.out.println("ERROR: " + e.getMessage());
                                } finally {
                                    System.out.println("Do you want to make a new deposit? [Y/N]");
                                    exi = sc.next().toUpperCase();
                                }
                            } while (exi.equals("Y"));
                        }

                        //Faz um saque na conta
                        if (op == 3) {
                            do {
                                System.out.print("Enter the amount to withdraw: ");
                                try {
                                    wit1.withdraw(sc.nextInt());
                                    System.out.println("SUCCESS: current account value: US$ " + ac1.getAccountBagage());
                                } catch (InputMismatchException e) {
                                    System.out.println("ERROR: Enter numbers only.");
                                    sc.nextLine();
                                } catch (InsufficientBalanceException | IllegalArgumentException e) {
                                    System.out.println("ERROR: " + e.getMessage());
                                } finally {
                                System.out.println("Do you want to make a new withdraw? [Y/N]");
                                exi = sc.next().toUpperCase();
                                }
                            } while (exi.equals("Y"));
                        }

                        //Informacoes da conta
                        if (op == 4) {
                            do {
                                System.out.println("----------------------");
                                System.out.println(ac1.informationAccount());
                                System.out.print("To return to the beginning press (ENTER).");
                                exi = sc.nextLine();
                            } while (!exi.isBlank());
                        }
                    } while (op != 5);
                    break;

                //Criacao de conta
                case 2:
                    do {
                        System.out.println("----------------------");
                        System.out.print("Create name: ");
                        String createName = sc.nextLine();

                        System.out.print("Create username: ");
                        String createUsername = sc.next();

                        System.out.print("Create password: ");
                        String createPassword = sc.next();
                        sc.nextLine();

                        try {
                            login.createLogin(createUsername, createPassword, createName);
                            System.out.println("Account created successfully!");
                            System.out.println("----------------------");
                            System.out.println(ac1.informationAccount());
                        } catch (CredentialAuthenticationException e) {
                            System.out.println("ERROR: " + e.getMessage());
                        } finally {
                            System.out.print("To return to the beginning press (ENTER).");
                            exi = sc.nextLine();
                        }
                    } while (!exi.isBlank());
            }
        } while (op2 != 3);
    }
}