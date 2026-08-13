/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Goku extends Personagem{
    private int Ki;
  
    @Override public void atacar(){
        System.out.println("Genki damaaaaaaaaaaaaa!");
    };

    public Goku(int Ki, String nome, int vida, int energia) {
        super(nome, vida, energia);
        this.Ki = Ki;
    };        
};
