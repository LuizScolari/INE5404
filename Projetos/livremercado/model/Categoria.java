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
public class Categoria {
    private String nome;
    private List<Produto> produtos;
    private List<Categoria> subcategorias;
    
    public Categoria(String nome){
        this.nome = nome;
        produtos = new ArrayList<>();
        subcategorias = new ArrayList<>();
    }
    
    public void adicioneProduto(Produto produto){
        if (!produtos.contains(produto)){
            produtos.add(produto);
            if (!produto.getCategoria().equals(this)){
                produto.getCategoria().produtos.remove(produto);
                produto.setCategoria(this);
            }
        }
    }
    
    public void adicioneSubcategoria(Categoria subcategoria){
        if (!subcategorias.contains(subcategoria)){
            subcategorias.add(subcategoria);
        }   
    }
    
    public void removaSubcategoria(Categoria subcategoria, boolean permanente) throws IllegalArgumentException {
        
        if (permanente){
            for (Produto produto: subcategoria.produtos){
                produtos.add(produto);
                produto.setCategoria(this);
            }
            subcategoria.produtos.clear();
            for (Categoria sub: subcategoria.subcategorias){
                subcategorias.add(sub);
            }
            subcategoria.subcategorias.clear();
        }
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
