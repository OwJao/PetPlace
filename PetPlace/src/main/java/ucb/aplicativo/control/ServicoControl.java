/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import ucb.aplicativo.dao.serviço.ServicoDAO;
import ucb.aplicativo.dao.serviço.ServicoDAOMySQL;
import ucb.aplicativo.model.Servico;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Gustavo NF
 */


public class ServicoControl {

    private ServicoDAO servicoDAO;

    public ServicoControl() {
        this.servicoDAO = new ServicoDAOMySQL();
    }

    public void cadastrarServico(BigDecimal preco, int banho, int tosa) throws Exception {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Preço inválido");
        }

        if (banho != 0 && banho != 1) {
            throw new Exception("Valor inválido para banho");
        }

        if (tosa != 0 && tosa != 1) {
            throw new Exception("Valor inválido para tosa");
        }

        Servico servico = new Servico(0, preco, banho, tosa);
        servicoDAO.salvar(servico);
    }

    public List<Servico> listarServicos() throws Exception {
        return servicoDAO.listarTodos();
    }

    public Servico buscarPorId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }
        Servico servico = servicoDAO.buscarPorId(id);
        if (servico == null) {
            throw new Exception("Serviço não encontrado");
        }
        return servico;
    }

    public List<Servico> listarPorBanho(int banho) throws Exception {
        if (banho != 0 && banho != 1) {
            throw new Exception("Valor inválido para filtro de banho");
        }
        return servicoDAO.listarPorBanho(banho);
    }

    public void atualizarServico(int id, BigDecimal preco, int banho, int tosa) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        Servico servicoExistente = servicoDAO.buscarPorId(id);
        if (servicoExistente == null) {
            throw new Exception("Serviço não encontrado");
        }

        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0) {
            throw new Exception("Preço inválido");
        }

        servicoExistente.setPRECO(preco);
        servicoExistente.setBANHO(banho);
        servicoExistente.setTOSA(tosa);

        servicoDAO.atualizar(servicoExistente);
    }

    public void deletarServico(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        Servico servico = servicoDAO.buscarPorId(id);
        if (servico == null) {
            throw new Exception("Serviço não encontrado");
        }

        servicoDAO.deletar(id);
    }
}
