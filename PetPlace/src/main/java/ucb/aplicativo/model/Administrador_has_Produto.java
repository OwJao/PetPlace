/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */
public class Administrador_has_Produto {

    private int ADMINISTRADOR_idADMINISTRADOR;
    private int PRODUTO_idPRODUTO;         

    public  Administrador_has_Produto() {
    }

    public  Administrador_has_Produto(int ADMINISTRADOR_idADMINISTRADOR, int PRODUTO_idPRODUTO) {
        this.ADMINISTRADOR_idADMINISTRADOR = ADMINISTRADOR_idADMINISTRADOR;
        this.PRODUTO_idPRODUTO = PRODUTO_idPRODUTO;
    }

    // Getters e Setters

    public int getADMINISTRADOR_idADMINISTRADOR() {
        return ADMINISTRADOR_idADMINISTRADOR;
    }

    public void setADMINISTRADOR_idADMINISTRADOR(int ADMINISTRADOR_idADMINISTRADOR) {
        this.ADMINISTRADOR_idADMINISTRADOR = ADMINISTRADOR_idADMINISTRADOR;
    }

    public int getPRODUTO_idPRODUTO() {
        return PRODUTO_idPRODUTO;
    }

    public void setPRODUTO_idPRODUTO(int PRODUTO_idPRODUTO) {
        this.PRODUTO_idPRODUTO = PRODUTO_idPRODUTO;
    }

    @Override
    public String toString() {
        return "ADMINISTRADOR_has_PRODUTO {" +
                "ADMINISTRADOR_idADMINISTRADOR=" + ADMINISTRADOR_idADMINISTRADOR +
                ", PRODUTO_idPRODUTO=" + PRODUTO_idPRODUTO +
                '}';
    }
}
