/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import java.util.List;
import ucb.aplicativo.dao.compra.CompraDAO;
import ucb.aplicativo.dao.compra.CompraDAOMySQL;
import ucb.aplicativo.model.Compra;

/**
 *
 * @author Gustavo NF
 */


public class CompraControl {

    private CompraDAO compraDAO;

    public CompraControl() {
        this.compraDAO = new CompraDAOMySQL();
    }

    public void cadastrarCompra(Compra compra) throws Exception {
        if (compra.getCPF() == null || compra.getCPF().isEmpty()) {
            throw new Exception("CPF é obrigatório.");
        }
        if (compra.getVALOR_TOTAL() == null || compra.getVALOR_TOTAL().doubleValue() <= 0) {
            throw new Exception("Valor total deve ser maior que zero.");
        }
        if (compra.getDATA_COMPRA() == null) {
            throw new Exception("Data da compra é obrigatória.");
        }
        compraDAO.salvar(compra);
    }

    public Compra buscarPorId(int id) throws Exception {
        Compra compra = compraDAO.buscarPorId(id);
        if (compra == null) {
            throw new Exception("Compra não encontrada.");
        }
        return compra;
    }

    public List<Compra> buscarPorCpf(String cpf) throws Exception {
        return compraDAO.buscarPorCpf(cpf);
    }

    public List<Compra> listarTodas() throws Exception {
        return compraDAO.listarTodos();
    }

    public void atualizarCompra(Compra compra) throws Exception {
        if (compra.getIdCOMPRA() <= 0) {
            throw new Exception("ID da compra inválido para atualização.");
        }
        compraDAO.atualizar(compra);
    }

    public void deletarCompra(int id) throws Exception {
        compraDAO.deletar(id);
    }
}

