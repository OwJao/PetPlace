/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class AnimalDeEstimacao {

  
    private int idANIMAL_DE_ESTIMACAO; // INT PRIMARY KEY
    private String NOME;            
    private String RACA;            
    private int IDADE;            
    private String SEXO;             
    private String CPF_CLIENTE;   

   
    public AnimalDeEstimacao() {
    }

    public AnimalDeEstimacao(int idANIMAL_DE_ESTIMACAO, String NOME, String RACA, int IDADE, String SEXO, String CPF_CLIENTE) {
        this.idANIMAL_DE_ESTIMACAO = idANIMAL_DE_ESTIMACAO;
        this.NOME = NOME;
        this.RACA = RACA;
        this.IDADE = IDADE;
        this.SEXO = SEXO;
        this.CPF_CLIENTE = CPF_CLIENTE;
    }

    // Getters e Setters

    public int getIdANIMAL_DE_ESTIMACAO() {
        return idANIMAL_DE_ESTIMACAO;
    }

    public void setIdANIMAL_DE_ESTIMACAO(int idANIMAL_DE_ESTIMACAO) {
        this.idANIMAL_DE_ESTIMACAO = idANIMAL_DE_ESTIMACAO;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getRACA() {
        return RACA;
    }

    public void setRACA(String RACA) {
        this.RACA = RACA;
    }

    public int getIDADE() {
        return IDADE;
    }

    public void setIDADE(int IDADE) {
        this.IDADE = IDADE;
    }

    public String getSEXO() {
        return SEXO;
    }

    public void setSEXO(String SEXO) {
        this.SEXO = SEXO;
    }

    public String getCPF_CLIENTE() {
        return CPF_CLIENTE;
    }

    public void setCPF_CLIENTE(String CPF_CLIENTE) {
        this.CPF_CLIENTE = CPF_CLIENTE;
    }

    @Override
    public String toString() {
        return "ANIMAL_DE_ESTIMACAO {" +
                "idANIMAL_DE_ESTIMACAO=" + idANIMAL_DE_ESTIMACAO +
                ", NOME='" + NOME + '\'' +
                ", RACA='" + RACA + '\'' +
                ", IDADE=" + IDADE +
                ", SEXO='" + SEXO + '\'' +
                ", CPF_CLIENTE='" + CPF_CLIENTE + '\'' +
                '}';
    }
}