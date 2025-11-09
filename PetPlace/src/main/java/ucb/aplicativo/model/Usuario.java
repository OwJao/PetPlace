/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String tipoUsuario;
    
    // Construtor Padrão
    public Usuario() {}
    
    // Construtor para Novo Usuário
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = "CLIENTE"; // Padrão
    }
    
    // Construtor Completo
    public Usuario(Long id, String nome, String email, String senha, String tipoUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }
    
    //Métodos Getters e Setters
    public Long getId() { 
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() { 
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome; 
    }

    public String getEmail() { 
        return email; 
    }
    public void setEmail(String email) { 
        this.email = email;
    }

    public String getSenha() { 
        return senha; 
    }
    public void setSenha(String senha) {
        this.senha = senha; 
    }
    
    public String getTipoUsuario() {
        return tipoUsuario;
    }
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario; 
    }
    
    @Override
    public String toString() {
        return "Usuario {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipoUsuario='" + tipoUsuario + '\'' +
                // A senha não deve ser exibida
                '}';
}
    
}
