/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

import java.math.BigDecimal;

public class ItemPedido {
    
    private Long id;
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;
    private BigDecimal precoUnitario;
    
    // Construtor Padrão
    public ItemPedido() {}
    
    // Construtor para Adicionar um Item ao Pedido
    public ItemPedido(Long pedidoId, Long produtoId, Integer quantidade, BigDecimal precoUnitario) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    
    // Construtor Completo 
    public ItemPedido(Long id, Long pedidoId, Long produtoId, Integer quantidade, BigDecimal precoUnitario) {
        this.id = id;
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
    
    //Exmplo de Regra de nogico a ser adicionado
    public BigDecimal getSubtotal() {
        if (precoUnitario == null || quantidade == null) {
            return BigDecimal.ZERO;
        }
  
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
    
    //Métodos Getters e Setter
    public Long getId() { 
        return id; 
    }
    public void setId(Long id) { 
        this.id = id;
    }

    public Long getPedidoId() { 
        return pedidoId; 
    }
    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() { 
        return produtoId;
    }
    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() { 
        return quantidade; 
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade; 
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario; 
    }
    public void setPrecoUnitario(BigDecimal precoUnitario) { 
        this.precoUnitario = precoUnitario; 
    }
    
    @Override
    public String toString() {
        return "ItemPedido {" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", produtoId=" + produtoId +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + getSubtotal() + 
                '}';
    }
    
}
