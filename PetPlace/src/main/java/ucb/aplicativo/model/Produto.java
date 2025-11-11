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
import java.time.LocalDateTime;

public class Produto {

    private Long idProduto;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private Long idFornecedor;
    private LocalDateTime dataCadastro;

    // Construtor padrão
    public Produto() {
        this.dataCadastro = LocalDateTime.now();
    }

    // Construtor para adicionar novo produto
    public Produto(String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque, Long idFornecedor) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.idFornecedor = idFornecedor;
        this.dataCadastro = LocalDateTime.now();
    }

    // Construtor completo
    public Produto(Long idProduto, String nome, String descricao, BigDecimal preco, Integer quantidadeEstoque, Long idFornecedor, LocalDateTime dataCadastro) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.idFornecedor = idFornecedor;
        this.dataCadastro = dataCadastro;
    }

    // Getters e Setters
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Produto {" +
                "idProduto=" + idProduto +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", idFornecedor=" + idFornecedor +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
