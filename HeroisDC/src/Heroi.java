/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Heroi {
    private String nome;
    int vida;
    int energia;
    int velocidade;  
    
   public void apresentar(){
       System.out.println("Ola! Eu sou o " + nome + " e sou um heroi");
   } 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
   
}
