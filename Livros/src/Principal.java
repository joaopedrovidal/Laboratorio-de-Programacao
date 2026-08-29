/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author Aluno
 */
public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Biblioteca minhaBiblioteca = new Biblioteca();
        GerenciamentoDePessoas gerenciamentoDePessoas = new GerenciamentoDePessoas();
        GerenciamentoDeEmprestimos gerenciamentoDeEmprestimos = new GerenciamentoDeEmprestimos(gerenciamentoDePessoas.pessoas, minhaBiblioteca.livros);

        int opcao = 0;

        while (true) {
            System.out.println(
                        "\n--- MENU DO SISTEMA ---" +

                        "\n\n--- MENU DE LIVROS ---"+
                        "\nDigite 1 para Adicionar um Livro" +
                        "\nDigite 2 para Listar os Livros" +
                        "\nDigite 3 para Editar um Livro pelo codigo" +
                        "\nDigite 4 para Excluir um Livro pelo codigo" +

                        "\n\n--- MENU DE PESSOAS ---" +
                        "\nDigite 6 para Cadastrar uma Pessoa" +
                        "\nDigite 7 para Listar Pessoas" +
                        "\nDigite 8 para Excluir uma Pessoa" +
                        "\nDigite 9 para Editar uma Pessoa" +

                        "\n\n--- MENU DE EMPRESTIMOS ---" +
                        "\nDigite 10 para Realizar o Emprestimo de um Livro" +
                        "\nDigite 11 para Realizar a Listagem dos Emprestimos" +
                        "\nDigite 12 para Realizar a Devolução de um Emprestimo" +

                        "\nDigite qualquer outra tecla para sair do menu"
            );

        opcao = input.nextInt();

            switch (opcao) {

                case 1: minhaBiblioteca.cadastrarLivro();
                break;
                case 2: minhaBiblioteca.listarLivros();
                break;
                case 3:
                    System.out.println("Digite o Codigo do Livro que deseja Editar: ");
                    minhaBiblioteca.editarLivroNaBibliotecaPeloCodigo();
                break;
                case 4:
                    System.out.println("Digite o Codigo do Livro que deseja Excluir: ");
                    minhaBiblioteca.excluirLivroPorCodigo();
                break;
                case 6: gerenciamentoDePessoas.cadastrarPessoa();
                break;
                case 7: gerenciamentoDePessoas.listarPessoas();
                break;
                case 8: gerenciamentoDePessoas.excluirPessoa();
                break;
                case 9: gerenciamentoDePessoas.editarPessoa();
                break;
                case 10: gerenciamentoDeEmprestimos.realizarEmprestimo();
                break;
                case 11: gerenciamentoDeEmprestimos.listarEmprestimos();
                break;
                case 12: gerenciamentoDeEmprestimos.realizarDevolucao();
                break;
                default:
                    System.out.println("Saindo do sistema...");
                    input.close();
                    System.exit(0);
            }
        }
    }
}
