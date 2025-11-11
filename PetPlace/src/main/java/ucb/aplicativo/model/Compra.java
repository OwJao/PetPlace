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
import java.time.LocalDateTime;
import java.util.List;

public class Compra {

    private Long idCompra;
    private String cpfCliente; 
    private LocalDateTime dataCompra;
    private BigDecimal valorTotal;
    private String statusCompra;
    private List<CompraProduto> itens;

    // Construtor padrão
    public Compra() {
        this.dataCompra = LocalDateTime.now();
        this.valorTotal = BigDecimal.ZERO;
        this.statusCompra = "ABERTA";
    }

    // Construtor para nova compra
    public Compra(String cpfCliente) {
        this.cpfCliente = cpfCliente;
        this.dataCompra = LocalDateTime.now();
        this.valorTotal = BigDecimal.ZERO;
        this.statusCompra = "ABERTA";
    }

    // Construtor completo
    public Compra(Long idCompra, String cpfCliente, LocalDateTime dataCompra, BigDecimal valorTotal, String statusCompra, List<CompraProduto> itens) {
        this.idCompra = idCompra;
        this.cpfCliente = cpfCliente;
        this.dataCompra = dataCompra;
        this.valorTotal = valorTotal;
        this.statusCompra = statusCompra;
        this.itens = itens;
    }

    // Getters e Setters
    public Long getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(String statusCompra) {
        this.statusCompra = statusCompra;
    }

    public List<CompraProduto> getItens() {
        return itens;
    }

    public void setItens(List<CompraProduto> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Compra {" +
                "idCompra=" + idCompra +
                ", cpfCliente='" + cpfCliente + '\'' +
                ", dataCompra=" + dataCompra +
                ", valorTotal=" + valorTotal +
                ", statusCompra='" + statusCompra + '\'' +
                ", itens=" + (itens != null ? itens.size() : 0) +
                '}';
    }
}
