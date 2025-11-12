/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */
        
public class Cliente_has_Servico {

    private String CLIENTE_CPF;
    private int CLIENTE_COMPRA_idCOMPRA;
    private int SERVICO_idSERVICO;

    public Cliente_has_Servico() {
    }

  
    public Cliente_has_Servico(String CLIENTE_CPF, int CLIENTE_COMPRA_idCOMPRA, int SERVICO_idSERVICO) {
        this.CLIENTE_CPF = CLIENTE_CPF;
        this.CLIENTE_COMPRA_idCOMPRA = CLIENTE_COMPRA_idCOMPRA;
        this.SERVICO_idSERVICO = SERVICO_idSERVICO;
    }

    // Getters e Setters

    public String getCLIENTE_CPF() {
        return CLIENTE_CPF;
    }

    public void setCLIENTE_CPF(String CLIENTE_CPF) {
        this.CLIENTE_CPF = CLIENTE_CPF;
    }

    public int getCLIENTE_COMPRA_idCOMPRA() {
        return CLIENTE_COMPRA_idCOMPRA;
    }

    public void setCLIENTE_COMPRA_idCOMPRA(int CLIENTE_COMPRA_idCOMPRA) {
        this.CLIENTE_COMPRA_idCOMPRA = CLIENTE_COMPRA_idCOMPRA;
    }

    public int getSERVICO_idSERVICO() {
        return SERVICO_idSERVICO;
    }

    public void setSERVICO_idSERVICO(int SERVICO_idSERVICO) {
        this.SERVICO_idSERVICO = SERVICO_idSERVICO;
    }

    @Override
    public String toString() {
        return "CLIENTE_has_SERVICO {" +
                "CLIENTE_CPF='" + CLIENTE_CPF + '\'' +
                ", CLIENTE_COMPRA_idCOMPRA=" + CLIENTE_COMPRA_idCOMPRA +
                ", SERVICO_idSERVICO=" + SERVICO_idSERVICO +
                '}';
    }
}
