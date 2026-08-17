
import java.util.ArrayList;

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
            
    public void adicionarLivro(Livro livro){
        livros.add(livro);
        
        System.out.println("Livro adicionado: " + livro.getTitulo() + " com sucesso!" );
    }
    
    public void listarLivros(){
        for(Livro l : livros){
            System.out.println(l.getTitulo());
        }
    }
    
    public Livro buscarLivroPorTitulo(String titulo){
        
        for(Livro l : livros){
            if(l.getTitulo().equalsIgnoreCase(titulo))
                return l;
        }
        return null;
    }
}
