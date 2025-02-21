/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projetos.livremercado.model;

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
       
        int quantiaEstoque = vendedor.getEstoque().quantidadeEmEstoque(produto);
        
        if (quantiaEstoque < quantidade){
            throw new IllegalArgumentException();
        }
        
        for (ItemCompra item: itens){
            if(item.getProduto().equals(produto) && item.getVendedor().equals(vendedor)){
                if (item.getQuantidade()+quantidade > quantiaEstoque){
                    throw new IllegalArgumentException();
                }
                item.adicioneQuantidade(quantidade);
                return;
            }
        }
        itens.add(new ItemCompra(produto, vendedor, quantidade));
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
