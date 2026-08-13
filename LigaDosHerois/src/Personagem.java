/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public abstract class Personagem {
    private String nome;
    private int vida;
    private int energia;
    
    public Personagem(String nome, int vida, int energia) {
        this.nome = nome;
        this.vida = vida;
        this.energia = energia;
    }
    
    public void apresentar(){
        System.out.println("Ola! Eu sou o " + nome + " e sou um dos personagens do seu jogo");
    };
    
    public abstract void atacar();

}
