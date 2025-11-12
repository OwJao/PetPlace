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

    
    private int idFORNECEDOR; // INT PRIMARY KEY
    private String NOME;     
    private String TELEFONE;  
    private String EMAIL;     

    public Fornecedor() {
    }

    public Fornecedor(int idFORNECEDOR, String NOME, String TELEFONE, String EMAIL) {
        this.idFORNECEDOR = idFORNECEDOR;
        this.NOME = NOME;
        this.TELEFONE = TELEFONE;
        this.EMAIL = EMAIL;
    }

    // Getters e Setters

    public int getIdFORNECEDOR() {
        return idFORNECEDOR;
    }

    public void setIdFORNECEDOR(int idFORNECEDOR) {
        this.idFORNECEDOR = idFORNECEDOR;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return "FORNECEDOR {" +
                "idFORNECEDOR=" + idFORNECEDOR +
                ", NOME='" + NOME + '\'' +
                ", TELEFONE='" + TELEFONE + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                '}';
    }
}