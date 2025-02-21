/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projetos.livremercado.model;

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
        carrinho.getItens().removeIf(item->item.getQuantidade()==0);
    }
    
    public Carrinho getCarrinho(){
        return carrinho;
    }
}
