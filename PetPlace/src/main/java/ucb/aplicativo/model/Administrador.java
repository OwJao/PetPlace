/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class Administrador extends Usuario {

    private String cargo;


    // Construtor padrão
    public Administrador() {
        super();
        this.tipoUsuario = "ADMIN";
    }

    // Construtor para novo administrador
    public Administrador(String nome, String email, String senha, String cargo) {
        super(nome, email, senha, "ADMIN");
        this.cargo = cargo;
     
    }

    // Construtor completo
    public Administrador(Long id, String nome, String email, String senha, String cargo) {
        super(id, nome, email, senha, "ADMIN");
        this.cargo = cargo;
 
    }

    // Getters e Setters
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    @Override
    public String toString() {
        return "Administrador {" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

  @Override
public void exibirPerfil() {
    System.out.println("Administrador: " + getNome() + " | Tipo: " + getTipoUsuario());
}

}

