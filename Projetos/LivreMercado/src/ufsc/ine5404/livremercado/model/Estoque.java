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
    private final ArrayList<ItemDeProduto> itensEmEstoque;

    public Estoque() {
        this.itensEmEstoque = new ArrayList<ItemDeProduto>();
        
    }
    public boolean add(Produto produto, int quantidade){
        ItemDeProduto itemDeProdutoParaAdicionar = new ItemDeProduto(produto, quantidade);
        return itensEmEstoque.add(itemDeProdutoParaAdicionar);
    }
    public boolean contains(Object o){
        return itensEmEstoque.contains(o);
    }
}
