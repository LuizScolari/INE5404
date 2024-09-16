/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ufsc.ine5404.livremercado;

import ufsc.ine5404.livremercado.model.Estoque;
import ufsc.ine5404.livremercado.model.Produto;

/**
 *
 * @author luizscolari
 */
public class LivreMercado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Produto novoProduto = new Produto("Arroz", 10.00);
        boolean resultado = estoque.add(novoProduto, 12);
        estoque.listarProdutos();
        //Acrescentar coisas ao estoque e listar produtos
    }
    
}
