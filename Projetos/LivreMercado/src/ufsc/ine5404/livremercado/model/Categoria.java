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
public class Categoria {
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subcategorias;
    
    public Categoria(String nome){
        this.nome = nome;
        this.produtos = new ArrayList<>();
        this.subcategorias = new ArrayList<>();
    }
    
    public void adicioneProduto(Produto produto){
        for (Produto p : produtos){
            if(p.getNome().equals(produto.getNome())){
                return;
            }
        }
        produtos.add(produto);
    }
    
    public void adicioneSubcategoria(Categoria subcategoria){
        if (!subcategorias.contains(subcategoria)){
            subcategorias.add(subcategoria);
        }   
    }
    
    public void removaSubcategoria(Categoria subcategoria){
        subcategorias.remove(subcategoria);
    }
    
    public String getNome(){
        return nome;
    }
    
    public List<Produto> getProdutos(){
        return produtos;
    }
    
    public List<Categoria> getSubcategorias(){
        return subcategorias;
    }
    
}
