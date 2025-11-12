/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class Cliente {

    private String cpf; // PRIMARY KEY
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    
    // Atributos que representam as chaves estrangeiras (IDs de outras tabelas)
    private int compra_idCOMPRA;
    private int animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO;

    /**
     * Construtor padrão.
     */
    public Cliente() {
    }


    public Cliente(String cpf, String nome, String telefone, String email, String endereco, 
                   int compra_idCOMPRA, int animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.compra_idCOMPRA = compra_idCOMPRA;
        this.animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO = animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO;
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCompra_idCOMPRA() {
        return compra_idCOMPRA;
    }

    public void setCompra_idCOMPRA(int compra_idCOMPRA) {
        this.compra_idCOMPRA = compra_idCOMPRA;
    }

    public int getAnimal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO() {
        return animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO;
    }

    public void setAnimal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO(int animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO) {
        this.animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO = animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", compra_idCOMPRA=" + compra_idCOMPRA +
                ", animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO=" + animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO +
                '}';
    }
}