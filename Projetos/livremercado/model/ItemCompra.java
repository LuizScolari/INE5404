/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projetos.livremercado.model;

/**
 *
 * @author luizscolari
 */
public class ItemCompra {
    private Produto produto;
    private int quantidade;
    private Vendedor vendedor;
    
    public ItemCompra(Produto produto, Vendedor vendedor, int quantidade){
        this.produto = produto;
        this.vendedor = vendedor;
        this.quantidade = quantidade;
    }
    public Produto getProduto(){
        return produto;        
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void adicioneQuantidade (int quantidade) {
        this.quantidade += quantidade;
    }
    public void setQuantidade (int quantidade) {
        this.quantidade = quantidade;
    }
    public Vendedor getVendedor(){
        return vendedor;
    }
}
