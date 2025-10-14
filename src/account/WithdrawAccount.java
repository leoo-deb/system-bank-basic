package account;

import exception.InsufficientBalanceException;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public record WithdrawAccount(Account account) {
    public static Scanner sc = new Scanner(System.in);

    //Metodo em que realiza uma acao de saque
    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");

        try {
            account.withdrawAccount(sc.nextDouble());
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
            System.out.println("SUCCESS: current account value: US$ " + nf.format(account.getAccountBagage()));
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter numbers only.");
            sc.nextLine();
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
