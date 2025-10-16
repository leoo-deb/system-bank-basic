package account;

import exception.InsufficientBalanceException;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class MainPainelAccount {
    private final Account account;
    private int op;
    private String exi;
    private Scanner sc = new Scanner(System.in);

    public MainPainelAccount(Account account) {
        this.account = account;
    }

    public void mainPane() {
        SharesAccount shares = new SharesAccount(account);
        do {
            System.out.println("""
                        ----------------------
                        [1] Check balance
                        [2] Make deposit
                        [3] Make withdrawal
                        [4] Consult extract
                        [5] Account information
                        [6] Exit
                        ----------------------""");
            System.out.print("Choice an option: ");
            op = sc.nextInt();
            sc.nextLine();

            //Verifica o saldo da conta
            if (op == 1) {
                do {
                    NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
                    System.out.println("The current account balance is: US$ " + nf.format(account.getAccountBagage()));
                    System.out.print("To return to the beginning press (ENTER).");
                    exi = sc.nextLine();
                } while (!exi.isBlank());
            }

            //Faz um deposito na conta
            if (op == 2) {
                do {
                    shares.deposit();
                    System.out.println("Do you want to make a new deposit? [Y/N]");
                    exi = sc.next().toUpperCase();
                } while (exi.equals("Y"));
            }

            //Faz um saque na conta
            if (op == 3) {
                do {
                    shares.withdraw();
                    System.out.println("Do you want to make a new withdraw? [Y/N]");
                    exi = sc.next().toUpperCase();
                } while (exi.equals("Y"));
            }

            if (op == 4) {
                do {
                    System.out.println("----------------------");
                    shares.displayExtract();
                    System.out.print("To return to the beginning press (ENTER).");
                    exi = sc.nextLine();
                } while (!exi.isBlank());

            }

            //Informacoes da conta
            if (op == 5) {
                do {
                    System.out.println("----------------------");
                    System.out.println(account.informationAccount());
                    shares.displayExtract();
                    System.out.print("To return to the beginning press (ENTER).");
                    exi = sc.nextLine();
                } while (!exi.isBlank());
            }
        } while (op != 6);
    }
}