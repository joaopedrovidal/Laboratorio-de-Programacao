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
        Heroi batman = new Batman();
        Heroi superman = new Heroi();
        
        batman.setNome("Joao Pedro Vidal dos Santos");
        batman.vida = 100;
        batman.energia = 90;
        batman.velocidade = 30;
        
        batman.apresentar();
        superman.apresentar();
        
                
        superman.setNome("Guilherme Vidal dos Santos");
        superman.energia = 90;
        superman.vida = 100;
        superman.velocidade = 50;
        
        
        
        
    }
}
