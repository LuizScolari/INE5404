/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufsc.ine5404.livremercado.model;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author luizscolari
 */
public class Estoque {
    private List<ItemEstoque> itens;
    
    public Estoque(){
        itens = new ArrayList<ItemEstoque>();
    }
    
    public void adicioneItem(Produto produto, int quantidade){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                item.setQuantidade(item.getQuantidade()+quantidade);
                return;
            }
        }
        ItemEstoque itemNovo = new ItemEstoque(produto, quantidade);
        itens.add(itemNovo);
    }
    
    public List<ItemEstoque> getItens(){
        return itens;
    }
    
    public int quantidadeEmEstoque(Produto produto){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                return item.getQuantidade();
            }
        }
        return 0;
    }
    
    public void reduzaQuantidade(Produto produto, int quantidade){
        for(ItemEstoque item : itens){
            if(item.getProduto().equals(produto)){
                if(item.getQuantidade() <= 0){
                    getItens().remove(item);
                } else {
                    item.setQuantidade(item.getQuantidade()-quantidade);
                }
            }
        }
    }
}
