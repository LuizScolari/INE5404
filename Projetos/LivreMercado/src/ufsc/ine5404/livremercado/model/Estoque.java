/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufsc.ine5404.livremercado.model;

import java.util.ArrayList;

/**
 *
 * @author luizscolari
 */
public class Estoque {
    private final ArrayList<ItemEstoque> itensEmEstoque;

    public Estoque() {
        this.itensEmEstoque = new ArrayList<ItemEstoque>();
    }
    
    public ArrayList<ItemEstoque> getItens() {
        return itensEmEstoque;
    }
    
    public void adicioneItem(Produto produto, int quantidade) {
        for (ItemEstoque item : itensEmEstoque) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
            }
    }
    
        ItemEstoque itemDeProdutoParaAdicionar = new ItemEstoque(produto, quantidade);
        itensEmEstoque.add(itemDeProdutoParaAdicionar); 
    }
    
    public void reduzaQuantidade(Produto produto, int quantidade){
        for (ItemEstoque item : itensEmEstoque){
            if (item.getProduto().equals(produto)){
                int valor  = item.getQuantidade() - quantidade;
                if (valor > 0) {
                    item.setQuantidade(valor);
                } else {
                itensEmEstoque.remove(item);
                }                           
            }
        }
    }
    
    public int quantidadeEmEstoque(Produto produto) {
        for (ItemEstoque item : itensEmEstoque) {
            if (item.getProduto().equals(produto)) {
                return item.getQuantidade();
            }
        }
        return 0; 
    }
}
