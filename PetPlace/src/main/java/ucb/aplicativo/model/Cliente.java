/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class Cliente extends Usuario {

    private String cpf;
    private String telefone;
    private String endereco;

    // Construtor padrão
    public Cliente() {
        super();
        this.tipoUsuario = "CLIENTE";
    }

    // Construtor para novo cliente
    public Cliente(String nome, String email, String senha, String cpf, String telefone, String endereco) {
        super(nome, email, senha, "CLIENTE");
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Construtor completo
    public Cliente(Long id, String nome, String email, String senha, String cpf, String telefone, String endereco) {
        super(id, nome, email, senha, "CLIENTE");
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

   @Override
public void exibirPerfil() {
    System.out.println("Cliente: " + getNome() + " | Email: " + getEmail());
}
}
