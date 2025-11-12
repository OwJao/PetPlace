/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

public class PagamentoPix {

    private int idPAGAMENTO_PIX; // INT PRIMARY KEY
    private String CHAVE_PIX;    
    private int ID_COMPRA;    

    public PagamentoPix() {
    }

  
    public PagamentoPix(int idPAGAMENTO_PIX, String CHAVE_PIX, int ID_COMPRA) {
        this.idPAGAMENTO_PIX = idPAGAMENTO_PIX;
        this.CHAVE_PIX = CHAVE_PIX;
        this.ID_COMPRA = ID_COMPRA;
    }

    // Getters e Setters

    public int getIdPAGAMENTO_PIX() {
        return idPAGAMENTO_PIX;
    }

    public void setIdPAGAMENTO_PIX(int idPAGAMENTO_PIX) {
        this.idPAGAMENTO_PIX = idPAGAMENTO_PIX;
    }

    public String getCHAVE_PIX() {
        return CHAVE_PIX;
    }

    public void setCHAVE_PIX(String CHAVE_PIX) {
        this.CHAVE_PIX = CHAVE_PIX;
    }

    public int getID_COMPRA() {
        return ID_COMPRA;
    }

    public void setID_COMPRA(int ID_COMPRA) {
        this.ID_COMPRA = ID_COMPRA;
    }

    @Override
    public String toString() {
        return "PagamentoPix {" +
                "idPAGAMENTO_PIX=" + idPAGAMENTO_PIX +
                ", CHAVE_PIX='" + CHAVE_PIX + '\'' +
                ", ID_COMPRA=" + ID_COMPRA +
                '}';
    }
    
   
    public String realizarTransacao() {
        return "Transação PIX concluída para a Compra ID: " + ID_COMPRA;
    }
}
