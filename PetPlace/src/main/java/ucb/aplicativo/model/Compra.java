/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */

import java.math.BigDecimal;
import java.sql.Date; // Usando java.sql.Date para mapear DATA_COMPRA (DATE)

public class Compra {

    
    private int idCOMPRA; // INT PRIMARY KEY
    private String CPF;
    private Date DATA_COMPRA; 
    private BigDecimal VALOR_TOTAL; 
    private String idPRODUTO; 
    private int PAGAMENTO_PIX_idPAGAMENTO_PIX; 

    /**
     * Construtor padrão.
     */
    public Compra() {
    }

  
    public Compra(int idCOMPRA, String CPF, Date DATA_COMPRA, BigDecimal VALOR_TOTAL, 
                  String idPRODUTO, int PAGAMENTO_PIX_idPAGAMENTO_PIX) {
        this.idCOMPRA = idCOMPRA;
        this.CPF = CPF;
        this.DATA_COMPRA = DATA_COMPRA;
        this.VALOR_TOTAL = VALOR_TOTAL;
        this.idPRODUTO = idPRODUTO;
        this.PAGAMENTO_PIX_idPAGAMENTO_PIX = PAGAMENTO_PIX_idPAGAMENTO_PIX;
    }

    // Getters e Setters

    public int getIdCOMPRA() {
        return idCOMPRA;
    }

    public void setIdCOMPRA(int idCOMPRA) {
        this.idCOMPRA = idCOMPRA;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Date getDATA_COMPRA() {
        return DATA_COMPRA;
    }

    public void setDATA_COMPRA(Date DATA_COMPRA) {
        this.DATA_COMPRA = DATA_COMPRA;
    }

    public BigDecimal getVALOR_TOTAL() {
        return VALOR_TOTAL;
    }

    public void setVALOR_TOTAL(BigDecimal VALOR_TOTAL) {
        this.VALOR_TOTAL = VALOR_TOTAL;
    }

    public String getIdPRODUTO() {
        return idPRODUTO;
    }

    public void setIdPRODUTO(String idPRODUTO) {
        this.idPRODUTO = idPRODUTO;
    }

    public int getPAGAMENTO_PIX_idPAGAMENTO_PIX() {
        return PAGAMENTO_PIX_idPAGAMENTO_PIX;
    }

    public void setPAGAMENTO_PIX_idPAGAMENTO_PIX(int PAGAMENTO_PIX_idPAGAMENTO_PIX) {
        this.PAGAMENTO_PIX_idPAGAMENTO_PIX = PAGAMENTO_PIX_idPAGAMENTO_PIX;
    }

    @Override
    public String toString() {
        return "Compra {" +
                "idCOMPRA=" + idCOMPRA +
                ", CPF='" + CPF + '\'' +
                ", DATA_COMPRA=" + DATA_COMPRA +
                ", VALOR_TOTAL=" + VALOR_TOTAL +
                ", idPRODUTO='" + idPRODUTO + '\'' +
                ", PAGAMENTO_PIX_idPAGAMENTO_PIX=" + PAGAMENTO_PIX_idPAGAMENTO_PIX +
                '}';
    }
}