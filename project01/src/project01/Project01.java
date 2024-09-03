/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project01;

/**
 *
 * @author Luiz
 */
public class Project01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long fatorial = 1;
        long resultado = 1;
        while (fatorial != 21) {
            resultado *= fatorial;
            System.out.printf("Fatorial de %d é %d%n", fatorial, resultado);
            fatorial++;
        }
    }

}
