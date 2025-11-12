/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class Compra_has_Produto {


    private int COMPRA_idCOMPRA; 
    private int PRODUTO_idPRODUTO; 
     
    public Compra_has_Produto() {
    }

   
    public Compra_has_Produto(int COMPRA_idCOMPRA, int PRODUTO_idPRODUTO) {
        this.COMPRA_idCOMPRA = COMPRA_idCOMPRA;
        this.PRODUTO_idPRODUTO = PRODUTO_idPRODUTO;
    }

    // Getters e Setters

    public int getCOMPRA_idCOMPRA() {
        return COMPRA_idCOMPRA;
    }

    public void setCOMPRA_idCOMPRA(int COMPRA_idCOMPRA) {
        this.COMPRA_idCOMPRA = COMPRA_idCOMPRA;
    }

    public int getPRODUTO_idPRODUTO() {
        return PRODUTO_idPRODUTO;
    }

    public void setPRODUTO_idPRODUTO(int PRODUTO_idPRODUTO) {
        this.PRODUTO_idPRODUTO = PRODUTO_idPRODUTO;
    }

    @Override
    public String toString() {
        return "COMPRA_has_PRODUTO {" +
                "COMPRA_idCOMPRA=" + COMPRA_idCOMPRA +
                ", PRODUTO_idPRODUTO=" + PRODUTO_idPRODUTO +
                '}';
    }
}