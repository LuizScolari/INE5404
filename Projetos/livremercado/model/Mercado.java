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
public class Mercado {
    private List<Categoria> categorias;
    private List<Comprador> compradores;
    private List<Vendedor> vendedores;
    
    public Mercado(){
    categorias = new ArrayList<>();
    compradores = new ArrayList<>();
    vendedores = new ArrayList<>();
    }
    
    public void adicioneCategoria(Categoria categoria){
        if(!(categorias.contains(categoria))) {
                categorias.add(categoria);
            }
    }
    
    public void adicioneComprador(Comprador comprador){
        if(!(compradores.contains(comprador))) {
                compradores.add(comprador);
            }
    }
    
    public void adicioneVendedor(Vendedor vendedor){
        if(!(vendedores.contains(vendedor))) {
                vendedores.add(vendedor);
            }
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
