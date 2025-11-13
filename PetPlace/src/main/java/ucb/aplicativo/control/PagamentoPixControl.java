/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import ucb.aplicativo.dao.PagamentoPix.PagamentoPixDAO;
import ucb.aplicativo.dao.PagamentoPix.PagamentoPixDAOMySQL;
import ucb.aplicativo.model.PagamentoPix;
import java.util.List;

/**
 *
 * @author Gustavo NF
 */
 


public class PagamentoPixControl {

    private final PagamentoPixDAO pagamentoPixDAO;

    public PagamentoPixControl() {
        this.pagamentoPixDAO = new PagamentoPixDAOMySQL();
    }

    public void cadastrarPagamento(int id, String chavePix, int idCompra) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new Exception("Chave PIX obrigatória");
        }
        if (idCompra <= 0) {
            throw new Exception("ID da compra inválido");
        }

        PagamentoPix pagamento = new PagamentoPix(id, chavePix, idCompra);
        pagamentoPixDAO.salvar(pagamento);
    }

    public PagamentoPix buscarPorId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        PagamentoPix pagamento = pagamentoPixDAO.buscarPorId(id);
        if (pagamento == null) {
            throw new Exception("Pagamento não encontrado");
        }
        return pagamento;
    }

    public PagamentoPix buscarPorChavePix(String chavePix) throws Exception {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new Exception("Chave PIX obrigatória");
        }

        PagamentoPix pagamento = pagamentoPixDAO.buscarPorChavePix(chavePix);
        if (pagamento == null) {
            throw new Exception("Nenhum pagamento encontrado com essa chave PIX");
        }
        return pagamento;
    }

    public List<PagamentoPix> listarPagamentos() throws Exception {
        return pagamentoPixDAO.listarTodos();
    }

    public void atualizarPagamento(int id, String novaChavePix, int novoIdCompra) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }
        if (novaChavePix == null || novaChavePix.trim().isEmpty()) {
            throw new Exception("Chave PIX obrigatória");
        }
        if (novoIdCompra <= 0) {
            throw new Exception("ID da compra inválido");
        }

        PagamentoPix pagamentoExistente = pagamentoPixDAO.buscarPorId(id);
        if (pagamentoExistente == null) {
            throw new Exception("Pagamento não encontrado");
        }

        pagamentoExistente.setCHAVE_PIX(novaChavePix);
        pagamentoExistente.setID_COMPRA(novoIdCompra);

        pagamentoPixDAO.atualizar(pagamentoExistente);
    }

    public void deletarPagamento(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        PagamentoPix pagamento = pagamentoPixDAO.buscarPorId(id);
        if (pagamento == null) {
            throw new Exception("Pagamento não encontrado");
        }

        pagamentoPixDAO.deletar(id);
    }
}

