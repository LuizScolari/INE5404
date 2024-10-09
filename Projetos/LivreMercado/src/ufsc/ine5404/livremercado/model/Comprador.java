/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufsc.ine5404.livremercado.model;

/**
 *
 * @author luizscolari
 */
public class Comprador extends Pessoa{
    private Carrinho carrinho;
    
    public Comprador(String nome) {
        super(nome);
    }
    
    public void adicioneAoCarrinho(Produto produto, Vendedor vendedor, int quantidade){
        carrinho.adicioneItem(produto, vendedor, quantidade);
    }
    
    public void efetuarCompra(){
        for (ItemCompra item: carrinho.getItens()){
            
            try{
                item.getVendedor().getEstoque().reduzaQuantidade(item.getProduto(), item.getQuantidade());
                item.setQuantidade(0);
            }catch(IllegalArgumentException e){}
        }
        for (ItemCompra item: carrinho.getItens()){
            if(item.getQuantidade() == 0){
                carrinho.removaItem(item.getProduto());
            }
        }
    }
    
    public Carrinho getCarrinho(){
        return carrinho;
    }
}
