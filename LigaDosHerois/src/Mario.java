/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Mario extends Personagem {
    private int impulsao;
    
    @Override public void atacar(){
        System.out.println("Pulei em cima de voce!");  
    };

    public Mario(int impulsao, String nome, int vida, int energia) {
        super(nome, vida, energia);
        this.impulsao = impulsao;
    };    
}
