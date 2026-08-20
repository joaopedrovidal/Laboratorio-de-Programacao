/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class LivroFisico extends Livro {
    double peso;

    public LivroFisico(double peso, String titulo, String autor, int numeroDePaginas, int codigo) {
        super(titulo, autor, numeroDePaginas, codigo);
        this.peso = peso;
    }
    
    @Override public void descricao(){
        System.out.println("Este e um livro fisico: " + this.titulo);
    }
    
}
