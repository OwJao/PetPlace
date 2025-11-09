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
    
    private Long id;
    private String nome;
    private String descricaoProduto;
    private BigDecimal preco;
    private Integer quantidadeEstoque;
    private String categoria;
    private LocalDateTime dataCadastro;
    
    // Construtor Padrão
    public Produto() {
        this.dataCadastro = LocalDateTime.now(); // Define a data de criação/cadastro
    }
    
    // Construtor para Adicionar Novo Produto
    public Produto(String nome, String descricaoProduto, BigDecimal preco, Integer quantidadeEstoque, String categoria) {
        this.nome = nome;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.dataCadastro = LocalDateTime.now();
    }
    
    // Construtor Completo
    public Produto(Long id, String nome, String descricaoProduto, BigDecimal preco, Integer quantidadeEstoque, String categoria, LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricaoProduto = descricaoProduto;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.dataCadastro = dataCadastro;
    }
    //  Métodos Getters e Setters
    
    //ID
    public Long getId(){ 
        return id; 
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    // Nome
    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) { 
        this.nome = nome; 
    }

    // Descricao do Produto
    public String getDescricaoProduto() {
        return descricaoProduto; 
    }
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto; 
    }

    // Preco
    public BigDecimal getPreco() { 
        return preco; 
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    // Quantidade em Estoque
    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque; 
    }
    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque; 
    }

    // Categoria
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria; 
    }

    // Data de Cadastro
    public LocalDateTime getDataCadastro() {
        return dataCadastro; }
    // Opcional: setar a data de cadastro manualmente
    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro; 
    }
    
    @Override
    public String toString() {
        return "Produto {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", estoque=" + quantidadeEstoque +
                ", categoria='" + categoria + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
