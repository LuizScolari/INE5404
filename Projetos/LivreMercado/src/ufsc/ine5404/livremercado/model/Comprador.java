/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufsc.ine5404.livremercado.model;

/**
 *
 * @author luizscolari
 */
public class Comprador extends Pessoa{
    private Carrinho carrinho;
    
    public Comprador(String nome) {
        super(nome);
    }
    
    public void adicioneAoCarrinho(Produto produto, Vendedor vendedor, int quantidade){
        carrinho.adicioneItem(produto, vendedor, quantidade);
    }
    
    public void efeturarCompra(){
    }
    
    public Carrinho getCarrinho(){
        return carrinho;
    }
}
