/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estudantes;

/**
 *
 * @author luizscolari
 */
public class Main {
    public static void main(String[] args){
        Estudante estudante = new EstudanteDeGraduacao("Joao");
        EstudanteDeGraduacao graduando = new EstudanteDeGraduacao("Luiz", "Bolsista PET");
        
        System.out.println(estudante.getNome());
        System.out.println(graduando.getNome());
    }
}
