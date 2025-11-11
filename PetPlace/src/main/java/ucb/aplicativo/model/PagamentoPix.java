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

public class PagamentoPix extends Pagamento {

    private String chavePix;

    // Construtor padrão
    public PagamentoPix() {
        super();
    }

    // Construtor completo
    public PagamentoPix(Long idPagamento, Long idPedido, BigDecimal valor, String tipo, String chavePix) {
        super(idPagamento, idPedido, valor, tipo);
        this.chavePix = chavePix;
    }

    // Getters e Setters
    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public String realizarPagamento() {
        return "Pagamento via PIX realizado com sucesso! Valor: R$" + valor +
               " | Chave PIX: " + chavePix;
    }

    @Override
    public String toString() {
        return "PagamentoPix {" +
                "idPagamento=" + idPagamento +
                ", idPedido=" + idPedido +
                ", valor=" + valor +
                ", chavePix='" + chavePix + '\'' +
                '}';
    }
}

