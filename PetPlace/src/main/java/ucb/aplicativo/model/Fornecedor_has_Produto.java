/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */
public class Fornecedor_has_Produto {

    private int FORNECEDOR_idFORNECEDOR; 
    private int PRODUTO_idPRODUTO;    

    public Fornecedor_has_Produto() {
    }

    public Fornecedor_has_Produto(int FORNECEDOR_idFORNECEDOR, int PRODUTO_idPRODUTO) {
        this.FORNECEDOR_idFORNECEDOR = FORNECEDOR_idFORNECEDOR;
        this.PRODUTO_idPRODUTO = PRODUTO_idPRODUTO;
    }

    // Getters e Setters

    public int getFORNECEDOR_idFORNECEDOR() {
        return FORNECEDOR_idFORNECEDOR;
    }

    public void setFORNECEDOR_idFORNECEDOR(int FORNECEDOR_idFORNECEDOR) {
        this.FORNECEDOR_idFORNECEDOR = FORNECEDOR_idFORNECEDOR;
    }

    public int getPRODUTO_idPRODUTO() {
        return PRODUTO_idPRODUTO;
    }

    public void setPRODUTO_idPRODUTO(int PRODUTO_idPRODUTO) {
        this.PRODUTO_idPRODUTO = PRODUTO_idPRODUTO;
    }

    @Override
    public String toString() {
        return "FORNECEDOR_has_PRODUTO {" +
                "FORNECEDOR_idFORNECEDOR=" + FORNECEDOR_idFORNECEDOR +
                ", PRODUTO_idPRODUTO=" + PRODUTO_idPRODUTO +
                '}';
    }
}