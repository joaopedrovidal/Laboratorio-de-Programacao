/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Batman extends Heroi{
    public int sofrerDano(int vida){
        System.out.println("Batman sofeu dano e perdeu vida!");
        return this.vida - 10;
    }
    
    
    public void atacar(){
        System.out.println("Batman atacou!");
    }
}
