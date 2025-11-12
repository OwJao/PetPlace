/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author JOAO
 */

import java.math.BigDecimal;

public class Produto {

    private int idPRODUTO; // INT PRIMARY KEY
    private String NOME; 
    private String DESCRICAO;
    private BigDecimal PRECO; 
    private int QUANTIDADE_ESTOQUE; 

    /**
     * Construtor padrão.
     */
    public Produto() {
    }

   
    public Produto(int idPRODUTO, String NOME, String DESCRICAO, BigDecimal PRECO, int QUANTIDADE_ESTOQUE) {
        this.idPRODUTO = idPRODUTO;
        this.NOME = NOME;
        this.DESCRICAO = DESCRICAO;
        this.PRECO = PRECO;
        this.QUANTIDADE_ESTOQUE = QUANTIDADE_ESTOQUE;
    }

    // Getters e Setters

    public int getIdPRODUTO() {
        return idPRODUTO;
    }

    public void setIdPRODUTO(int idPRODUTO) {
        this.idPRODUTO = idPRODUTO;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public BigDecimal getPRECO() {
        return PRECO;
    }

    public void setPRECO(BigDecimal PRECO) {
        this.PRECO = PRECO;
    }

    public int getQUANTIDADE_ESTOQUE() {
        return QUANTIDADE_ESTOQUE;
    }

    public void setQUANTIDADE_ESTOQUE(int QUANTIDADE_ESTOQUE) {
        this.QUANTIDADE_ESTOQUE = QUANTIDADE_ESTOQUE;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "idPRODUTO=" + idPRODUTO +
                ", NOME='" + NOME + '\'' +
                ", DESCRICAO='" + DESCRICAO + '\'' +
                ", PRECO=" + PRECO +
                ", QUANTIDADE_ESTOQUE=" + QUANTIDADE_ESTOQUE +
                '}';
    }
}
