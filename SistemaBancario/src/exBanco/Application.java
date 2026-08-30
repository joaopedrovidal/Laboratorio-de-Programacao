package exBanco;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        Banco c1 = new Banco(1, 100, "Sede", 1);


        try {
            while (op != 4 && op != 5) {
                System.out.println("\n--- MENU DO SISTEMA BANCARIO ---"
                + "\n1 - Creditar Conta"
                + "\n2 - Debitar Conta"
                + "\n3 - Consultar Saldo"
                + "\n4 - Encerrar Conta"
                + "\n5 - Sair"
                );

                try {
                    op = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("\nErro: digite apenas numeros inteiros!");
                    sc.next();
                    op = 0;
                    continue;
                }

                switch (op) {
                    case 1:
                        if (c1.getTipo() == 4) {
                            System.out.println("\nErro: esta conta esta encerrada, nao e possivel creditar!");
                            break;
                        }

                        System.out.println("\nDigite o valor que voce deseja creditar: ");
                        try {
                            double saldoCreditado = sc.nextDouble();

                            if (saldoCreditado <= 0) {
                                System.out.println("\nErro: o valor creditado precisa ser maior que zero!");
                                break;
                            }

                            c1.creditarConta(saldoCreditado);
                            System.out.println("\nNovo saldo: R$ " + c1.getSaldo());
                        } catch (InputMismatchException e) {
                            System.out.println("\nErro: valor invalido! Digite apenas numeros.");
                            sc.next();
                        }
                    break;
                    case 2:
                        if (c1.getTipo() == 4) {
                            System.out.println("\nErro: esta conta esta encerrada, nao e possivel debitar!");
                            break;
                        }

                        System.out.println("\nDigite o valor que voce deseja debitar: ");
                        try {
                            double saldoDebitado = sc.nextDouble();

                            if (saldoDebitado <= 0) {
                                System.out.println("\nErro: o valor debitado precisa ser maior que zero!");
                                break;
                            }

                            c1.debitarSaldo(saldoDebitado);
                            System.out.println("\nNovo saldo: R$ " + c1.getSaldo());
                        } catch (InputMismatchException e) {
                            System.out.println("\nErro: valor invalido! Digite apenas numeros.");
                            sc.next();
                        }
                    break;
                    case 3:
                        System.out.println("\nO saldo atual da conta e: R$ " + c1.getSaldo());
                    break;
                    case 4:
                        if (c1.getSaldo() < 0) {
                            System.out.println("\nErro: nao e possivel encerrar uma conta com saldo negativo! Regularize o saldo primeiro.");
                            op = 0;
                            break;
                        }

                        double saldoEncerrado = c1.encerrarConta();
                        c1.textoEncerrar(saldoEncerrado);
                    break;
                    case 5:
                        System.out.println("\nSaindo do sistema... Ate logo!");
                    break;
                    default:
                        System.out.println("\nOpcao invalida! Escolha um numero entre 1 e 5.");
                    break;
                }
            }


        } catch (Exception e) {
            System.out.println("\nOcorreu um erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
