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

public class Servico {

    private Long idServico;
    private String categoria;  //BANHO OU TOSA
    private BigDecimal preco;

    // Construtor padrão
    public Servico() {
        super();
    }

    // Construtor completo
    public Servico(Long idServico, String categoria, BigDecimal preco) {
        this.idServico = idServico;
        this.categoria = categoria;
        this.preco = preco;
    }

    // Getters e Setters
    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    // toString
    @Override
    public String toString() {
        return "Servico {" +
                "idServico=" + idServico +
                ", categoria='" + categoria + '\'' +
                ", preco=" + preco +
                '}';
    }
}
