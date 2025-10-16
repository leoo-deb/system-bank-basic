import account.*;
import java.util.Scanner;

public class MainAccount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op2;
        Account ac1 = new Account();
        LoginAccount login = new LoginAccount(ac1);

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
                    if (login.accessLogin()) {
                        break;
                    }
                    MainPainelAccount main = new MainPainelAccount(ac1);
                    main.mainPane();
                    break;

                //Criacao de conta
                case 2:
                    if (login.createLogin()) {
                        break;
                    }
            }
        } while (op2 != 3);
    }
}