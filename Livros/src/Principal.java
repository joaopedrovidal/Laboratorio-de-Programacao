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
        LivroFisico meuLivroFisico = new LivroFisico(5, "LivroTesteUm", "Joao Pedro Vidal dos Santos", 10, 1);
        meuLivroFisico.descricao();

        Ebook meuEbook = new Ebook(100, "LivroTesteDois", "Guilherme Vidal dos Santos", 20, 2);
        meuEbook.descricao();

        Biblioteca minhaBiblioteca = new Biblioteca();
        minhaBiblioteca.adicionarLivro(meuEbook);
        minhaBiblioteca.adicionarLivro(meuLivroFisico);

        System.out.println("Livro localizado pelo titulo: " + minhaBiblioteca.buscarLivroPorTitulo().getTitulo());




        int opcao = 0;

        while (true) {
            System.out.println(
                        "\n--- MENU DA BIBLIOTECA ---" +
                        "\nDigite 1 para listar os livros" +
                        "\nDigite 2 para excluir um livro pelo codigo" +
                        "\nDigite 3 para editar um livro pelo codigo" +
                        "\nDigite 4 para adicionar um livro" +
                        "\nDigite qualquer outra tecla para sair do menu"
            );

        opcao = input.nextInt();

            switch (opcao) {

                case 1: minhaBiblioteca.listarLivros();
                break;
                case 2: minhaBiblioteca.excluirLivroPorCodigo();
                break;
                case 3: minhaBiblioteca.editarLivroNaBibliotecaPeloCodigo();
                break;
                //case 4: minhaBiblioteca.adicionarLivroNaBiblioteca();
                //break;
                default:
                    System.out.println("Saindo do sistema...");
                    input.close();
                    System.exit(0);
            }
        }

    }
}
