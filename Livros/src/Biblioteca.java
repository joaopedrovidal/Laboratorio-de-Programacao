
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Biblioteca {
    ArrayList<Livro> livros = new ArrayList();
    Scanner scanner = new Scanner(System.in);

    public void adicionarLivro(Livro livro){
        livros.add(livro);

        System.out.println("Livro adicionado: " + livro.getTitulo() + " com sucesso!" );
    }

    public void listarLivros(){
        System.out.println("Sua biblioteca esta composta pelos seguintes livros: ");
        for(Livro l : livros){
            System.out.println("Codigo: " + l.getCodigo() + " - " + "Autor: " + l.getTitulo());
        }
    }

    public Livro buscarLivroPorTitulo(){
        System.out.println("Digite o titulo do livro que deseja buscar: ");
        String tituloLivro = scanner.nextLine();

        for(Livro l : livros){
            if(l.getTitulo().equalsIgnoreCase(tituloLivro)){
                return l;
            }
        }
        return null;
    }

    public Livro buscarLivroPorCodio(){
        System.out.println("Digite o codigo que deseja buscar: ");
        int codigoLivro = scanner.nextInt();

        for(Livro l : livros){
            if (l.codigo == codigoLivro){
                return l;
            }
        }
        return null;
    }

    public void excluirLivroPorCodigo(){
        livros.remove(buscarLivroPorCodio());
        System.out.println("Livro removido com sucesso!" );

        listarLivros();
    }

    public void adicionarLivroNaBiblioteca(Livro livro){
        livros.add(livro);
    }

    public void editarLivroNaBibliotecaPeloCodigo(){
        buscarLivroPorCodio();
    }
}
