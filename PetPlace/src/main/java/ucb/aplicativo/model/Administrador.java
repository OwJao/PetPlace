/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class Administrador{

 
    private int idADMINISTRADOR; // INT PRIMARY KEY
    private String NOME;    
    private String LOGIN;   
    private String SENHA;  

    public Administrador() {
    }


    public Administrador(int idADMINISTRADOR, String NOME, String LOGIN, String SENHA) {
        this.idADMINISTRADOR = idADMINISTRADOR;
        this.NOME = NOME;
        this.LOGIN = LOGIN;
        this.SENHA = SENHA;
    }

    // Getters e Setters

    public int getIdADMINISTRADOR() {
        return idADMINISTRADOR;
    }

    public void setIdADMINISTRADOR(int idADMINISTRADOR) {
        this.idADMINISTRADOR = idADMINISTRADOR;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    @Override
    public String toString() {
        return "ADMINISTRADOR {" +
                "idADMINISTRADOR=" + idADMINISTRADOR +
                ", NOME='" + NOME + '\'' +
                ", LOGIN='" + LOGIN + '\'' +
             
                '}';
    }
    
    public boolean autenticar(String login, String senha) {
        return this.LOGIN.equals(login) && this.SENHA.equals(senha);
    }
}
