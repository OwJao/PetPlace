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

    private Long idAnimal;
    private String nome;
    private String especie;
    private String raca;
    private Integer idade;
    private String sexo;
    private Long idCliente;

    // Construtor padrão
    public AnimalDeEstimacao() {
    }

    // Construtor para novo animal
    public AnimalDeEstimacao(String nome, String especie, String raca, Integer idade, String sexo, Long idCliente) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.idCliente = idCliente;
    }

    // Construtor completo
    public AnimalDeEstimacao(Long idAnimal, String nome, String especie, String raca, Integer idade, String sexo, Long idCliente) {
        this.idAnimal = idAnimal;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.idCliente = idCliente;
    }

    // Getters e Setters
    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "AnimalDeEstimacao {" +
                "idAnimal=" + idAnimal +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", idCliente=" + idCliente +
                '}';
    }
}
