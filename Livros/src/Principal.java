/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Principal {

    public static void main(String[] args) {
        LivroFisico meuLivroFisico = new LivroFisico(5, "JavaScript e Melhor", "Joao Pedro Vidal", 10);
        meuLivroFisico.descricao();

        Ebook meuEbook = new Ebook(100, "I Love ReactJS", "Joao Pedro Vidal", 20);
        meuEbook.descricao();

        Biblioteca minhaBiblioteca = new Biblioteca();
        minhaBiblioteca.adicionarLivro(meuEbook);
        minhaBiblioteca.adicionarLivro(meuLivroFisico);

        minhaBiblioteca.buscarLivroPorTitulo("JavaScript e Melhor");
        minhaBiblioteca.buscarLivroPorTitulo("I Love ReactJS");

        System.out.println("Livro localizado pelo titulo: " + minhaBiblioteca.buscarLivroPorTitulo("JavaScript e Melhor").getTitulo());
        System.out.println("Livro localizado pelo titulo: " + minhaBiblioteca.buscarLivroPorTitulo("I Love ReactJS").getTitulo());
        
        minhaBiblioteca.listarLivros();

    }
}
