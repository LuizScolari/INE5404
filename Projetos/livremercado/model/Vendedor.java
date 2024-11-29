/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufsc.ine5404.livremercado.model;

/**
 *
 * @author luizscolari
 */
public class Vendedor extends Pessoa{
    
    private Estoque estoque = new Estoque();
    
    public Vendedor(String nome) {
        super(nome);
    }
    
    public void adicioneProdutoAoEstoque(Produto produto, int quantidade){
       estoque.adicioneItem(produto, quantidade);
    }
    public Estoque getEstoque(){
        return estoque;
    }
}
