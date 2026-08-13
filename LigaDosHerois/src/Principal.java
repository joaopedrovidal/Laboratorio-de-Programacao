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
        Goku goku = new Goku(500, "Joao Pedro Vidal", 100, 175);
        Sonic sonic = new Sonic(500, "Guilherme Vidal dos Santos", 100, 250);
        Mario mario = new Mario(500, "Jefferson Vidal dos Santos", 100, 120);
        
        goku.apresentar();
        sonic.apresentar();
        mario.apresentar();
        
        goku.atacar();
        sonic.atacar();
        mario.atacar();
    }
}
