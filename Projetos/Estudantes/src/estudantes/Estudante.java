/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estudantes;

import java.util.ArrayList;

/**
 *
 * @author luizscolari
 */
public abstract class Estudante{
    private String nome;
    
    public Estudante(String nome){
    this.nome = nome;
    }
    
    public abstract String getOrientado() throws UnsupportedOperationException;

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
} 