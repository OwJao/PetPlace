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

public abstract class Pagamento {

    protected Long idPagamento;
    protected Long idPedido;
    protected BigDecimal valor;
    protected String tipoPagamento;

    // Construtor padrão
    public Pagamento() {
    }

    // Construtor genérico
    public Pagamento(Long idPedido, BigDecimal valor, String tipoPagamento) {
        this.idPedido = idPedido;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }

    // Construtor completo
    public Pagamento(Long idPagamento, Long idPedido, BigDecimal valor, String tipoPagamento) {
        this.idPagamento = idPagamento;
        this.idPedido = idPedido;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
    }

    // Getters e Setters
    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    // Método abstrato - deve ser implementado nas subclasses
    public abstract String realizarPagamento();

    @Override
    public String toString() {
        return "Pagamento {" +
                "idPagamento=" + idPagamento +
                ", idPedido=" + idPedido +
                ", valor=" + valor +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                '}';
    }
}

