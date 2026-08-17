/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Ebook extends Livro {
    double tamanhoArquivo;
    
    public Ebook(double tamanhoArquivo, String titulo, String autor, int numeroDePaginas) {
        super(titulo, autor, numeroDePaginas);
        this.tamanhoArquivo = tamanhoArquivo;
    }
    
    @Override public void descricao(){
        System.out.println("Este e um Ebook: " + this.titulo);
    }
    
}
