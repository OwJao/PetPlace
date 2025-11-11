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

public class CompraProduto {

    private Long idItem;
    private Long idPedido;
    private Long idProduto;
    private Integer quantidade;
    private BigDecimal precoUnitario;

    // Construtor padrão
    public CompraProduto() {
    }

    // Construtor para adicionar novo item ao pedido
    public CompraProduto(Long idPedido, Long idProduto, Integer quantidade, BigDecimal precoUnitario) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Construtor completo
    public CompraProduto(Long idItem, Long idPedido, Long idProduto, Integer quantidade, BigDecimal precoUnitario) {
        this.idItem = idItem;
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    // Método auxiliar para calcular subtotal
    public BigDecimal getSubtotal() {
        if (precoUnitario == null || quantidade == null) {
            return BigDecimal.ZERO;
        }
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }

    // Getters e Setters
    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
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
                "idItem=" + idItem +
                ", idPedido=" + idPedido +
                ", idProduto=" + idProduto +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                ", subtotal=" + getSubtotal() +
                '}';
    }
}
