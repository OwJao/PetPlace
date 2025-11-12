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

    private int idSERVICO;         // INT PRIMARY KEY
    private BigDecimal PRECO;     
    private int BANHO;          
    private int TOSA;             

    public Servico() {
    }

    public Servico(int idSERVICO, BigDecimal PRECO, int BANHO, int TOSA) {
        this.idSERVICO = idSERVICO;
        this.PRECO = PRECO;
        this.BANHO = BANHO;
        this.TOSA = TOSA;
    }

    // Getters e Setters

    public int getIdSERVICO() {
        return idSERVICO;
    }

    public void setIdSERVICO(int idSERVICO) {
        this.idSERVICO = idSERVICO;
    }

    public BigDecimal getPRECO() {
        return PRECO;
    }

    public void setPRECO(BigDecimal PRECO) {
        this.PRECO = PRECO;
    }

  
    public int getBANHO() {
        return BANHO;
    }

    public void setBANHO(int BANHO) {
        this.BANHO = BANHO;
    }

    public int getTOSA() {
        return TOSA;
    }

    public void setTOSA(int TOSA) {
        this.TOSA = TOSA;
    }

    @Override
    public String toString() {
        return "SERVICO {" +
                "idSERVICO=" + idSERVICO +
                ", PRECO=" + PRECO +
                ", BANHO=" + (BANHO == 1 ? "Sim" : "Não") +
                ", TOSA=" + (TOSA == 1 ? "Sim" : "Não") +
                '}';
    }
}