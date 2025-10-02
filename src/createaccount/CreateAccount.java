package createaccount;

import account.Account;
import account.DepositAccount;
import account.WithdrawAccount;

import java.util.Scanner;

public class CreateAccount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op, op2;
        String exi, accessUsername, accessPassword, createUsername, createPassword;
        Account ac1 = new Account();
        DepositAccount dep1 = new DepositAccount(ac1);
        WithdrawAccount wit1 = new WithdrawAccount(ac1);

        do {
            System.out.println("""
                        ----------------------
                        [1] Acessar conta
                        [2] Criar conta
                        [3] Sair
                        ----------------------
                        """);
            System.out.print("Escolha uma opcao acima: ");
            op2 = sc.nextInt();

            switch (op2) {
                case 1:
                    System.out.print("Username: ");
                    accessUsername = sc.next();
                    System.out.print("Password: ");
                    accessPassword = sc.next();
                    ac1.login(accessUsername, accessPassword);

                    //Verificacao se o username e password fornecidos estao de
                    // de acordo que estao no "sistema"
                    if (ac1.login(accessUsername, accessPassword)) {
                        System.out.println("Login efetuado com sucesso!");
                        System.out.println("Bem vindo, " + ac1.getAccountName() + " ao System Banking");

                        do {
                            System.out.println("""
                            ----------------------
                            [1] Verificar saldo
                            [2] Realizar deposito
                            [3] Realizar saque
                            [4] Informacoes da conta
                            [5] Sair
                            ----------------------
                            """);
                            System.out.print("Escolha uma opcao acima: ");
                            op = sc.nextInt();

                            switch (op) {
                                //Verifica o saldo da conta
                                case 1:
                                        do {
                                            System.out.println("O saldo atual da conta e: R$ " + ac1.getAccountBagage());
                                            System.out.println("Para voltar ao inicio pressione a tecla (1).");
                                            exi = sc.next();
                                        } while (!exi.equals("1"));
                                    break;
                                //Faz um deposito na conta
                                case 2:
                                        do {
                                            System.out.println("Digite o valor para deposito: ");
                                            dep1.deposit(sc.nextDouble());
                                            System.out.println("Deseja realizar um novo deposito? [S/N]");
                                            exi = sc.next().toUpperCase();
                                        } while (exi.equals("S"));
                                    break;
                                //Faz um saque na conta
                                case 3:
                                        //Verifica inicialmente se o saldo da conta nao e 0 ou menor
                                        if (!(ac1.getAccountBagage() <= 0)) {
                                            do {
                                                System.out.println("Digite o valor para saque: ");
                                                double saque = sc.nextDouble();
                                                //Verifica se valor do saque e menor do que tem no saldo da conta,
                                                //senao, nao havera saque
                                                if (!(saque > ac1.getAccountBagage())) {
                                                    wit1.withdraw(saque);
                                                } else {
                                                    System.out.println("Saldo atual: R$ " + ac1.getAccountBagage());
                                                    System.out.println("ERROR: A conta nao possui saldo suficiente para a realizacao do saque.");
                                                }
                                                System.out.println("Deseja realizar um novo saque? [S/N]");
                                                exi = sc.next().toUpperCase();
                                            } while (exi.equals("S"));
                                        } else {
                                            System.out.println("A conta nao possui saldo suficiente.");
                                            break;
                                        }
                                    break;

                                case 4:
                                    do {
                                        System.out.println("----------------------");
                                        System.out.println(ac1.informationAccoount());
                                        System.out.println("Para voltar ao inicio pressione a tecla (1).");
                                        exi = sc.next();
                                    } while (!exi.equals("1"));
                                    break;

                                default:
                                    System.out.println("Digite os numeros somente dispostos acima.");
                            }
                        } while (op != 5);

                    } else {
                        System.out.println("ERROR: Username/password incorretos.");
                    }
                    break;

                case 2:
                    //Verifica se ja tem uma conta criada no "sistema",
                    //verificando se o metodo getAccountName() esta vazio
                    if (ac1.getAccountName().isEmpty()) {
                        System.out.println("-------CREATE ACCOUNT-------");
                        System.out.println("Create username: ");
                        createUsername = sc.next();
                        System.out.println("Create password: ");
                        createPassword = sc.next();
                        ac1.createLogin(createUsername, createPassword);
                        System.out.println("Conta criada com sucesso!");
                        System.out.println("----------------------");
                        System.out.println(ac1.informationAccoount());
                    } else {
                        System.out.println("ERROR: Ja existe uma conta criada nesse sistema.");
                        break;
                    }
                    break;
            }
        } while (op2 != 3);
    }
}