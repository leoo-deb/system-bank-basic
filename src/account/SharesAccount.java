package account;

import exception.InsufficientBalanceException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SharesAccount {
    private final Account account;
    private final ArrayList<String> extract;
    private final Scanner sc = new Scanner(System.in);

    public SharesAccount(Account account) {
        this.account = account;
        this.extract = new ArrayList<>();
    }

    //Metodo em que realiza uma acao de deposito
    public void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double value = sc.nextDouble();

        try {
            account.depositAccount(value);
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
            System.out.println("SUCCESS: Current account value: US$ " + nf.format(account.getAccountBagage()));
            this.extract.add("+" + value + " " + "(" + LocalDateTime.now() + ")");
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter numbers only.");
            sc.nextLine();
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e .getMessage());
        }
    }

    //Metodo em que realiza uma acao de saque
    public void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double value2 = sc.nextDouble();

        try {
            account.withdrawAccount(value2);
            NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
            System.out.println("SUCCESS: Current account value: US$ " + nf.format(account.getAccountBagage()));
            this.extract.add("-" + value2 + " " + "(" + LocalDateTime.now() + ")");
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Enter numbers only.");
            sc.nextLine();
        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void displayExtract() {
        for (String display: extract) {
            System.out.println(display);
        }
    }
}
