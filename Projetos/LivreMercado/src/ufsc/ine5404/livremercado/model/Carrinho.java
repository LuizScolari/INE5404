/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufsc.ine5404.livremercado.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizscolari
 */
public class Carrinho {
    private List<ItemCompra> itens;
    
    public Carrinho(){
        itens = new ArrayList();
    }
    public void adicioneItem(Produto produto, Vendedor vendedor, int quantidade){
        ItemCompra item = new ItemCompra(produto, vendedor, quantidade);
        
        for(ItemCompra p : itens){
            if(p.getProduto().equals(produto) && p.getVendedor().equals(vendedor)){
                item.setQuantidade(item.getQuantidade() + quantidade);
            }
        }
        itens.add(item);
    }
    public List<ItemCompra> getItens(){
        return itens;
    }
    public void removaItem(Produto produto){
        for(ItemCompra p : itens){
            if (p.getProduto().equals(produto)){
                itens.remove(produto);
            }
        }
    }
}
