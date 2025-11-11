/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class Fornecedor {

    private Long idFornecedor;
    private String nome;
    private String telefone;
    private String email;
    private String cnpj;
    private String endereco;

    // Construtor padrão
    public Fornecedor() {
    }

    // Construtor para novo fornecedor (sem ID)
    public Fornecedor(String nome, String telefone, String email, String cnpj, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    // Construtor completo (com ID)
    public Fornecedor(Long idFornecedor, String nome, String telefone, String email, String cnpj, String endereco) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    // Getters e Setters
    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Fornecedor {" +
                "idFornecedor=" + idFornecedor +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
