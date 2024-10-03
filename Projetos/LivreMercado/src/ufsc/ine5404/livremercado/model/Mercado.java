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
public class Mercado {
    private List<Categoria> categorias;
    private List<Comprador> compradores;
    private List<Vendedor> vendedores;
    
    public Mercado(){
    this.categorias = new ArrayList<>();
    this.compradores = new ArrayList<>();
    this.vendedores = new ArrayList<>();
    }
    
    public void adicioneCategoria(Categoria categoria){
        categorias.add(categoria);
    }
    
    public void adicioneComprador(Comprador comprador){
        compradores.add(comprador);
    }
    
    public void adicioneVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
    }
    
    public List<Categoria> getCategorias(){
        return categorias;
    }
    
    public List<Comprador> getCompradores(){
        return compradores;
    }
    
    public List<Vendedor> getVendedores(){
        return vendedores;
    }
}
