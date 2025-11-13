/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import ucb.aplicativo.dao.Fornecedor.FornecedorDAO;
import ucb.aplicativo.dao.Fornecedor.FornecedorDAOMySQL;
import ucb.aplicativo.model.Fornecedor;
import java.util.List;

/**
 *
 * @author Gustavo NF
 */


public class FornecedorControl {

    private final FornecedorDAO fornecedorDAO;

    public FornecedorControl() {
        this.fornecedorDAO = new FornecedorDAOMySQL();
    }

    public void cadastrarFornecedor(String nome, String telefone, String email) throws Exception {
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome inválido");
        }
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new Exception("Telefone inválido");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new Exception("Email inválido");
        }

        Fornecedor existente = fornecedorDAO.buscarPorEmail(email);
        if (existente != null) {
            throw new Exception("Já existe um fornecedor com esse email");
        }

        Fornecedor fornecedor = new Fornecedor(0, nome, telefone, email);
        fornecedorDAO.salvar(fornecedor);
    }

    public Fornecedor buscarPorId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        Fornecedor fornecedor = fornecedorDAO.buscarPorId(id);
        if (fornecedor == null) {
            throw new Exception("Fornecedor não encontrado");
        }

        return fornecedor;
    }

    public Fornecedor buscarPorEmail(String email) throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new Exception("Email inválido");
        }

        Fornecedor fornecedor = fornecedorDAO.buscarPorEmail(email);
        if (fornecedor == null) {
            throw new Exception("Fornecedor não encontrado");
        }

        return fornecedor;
    }

    public List<Fornecedor> listarFornecedores() throws Exception {
        return fornecedorDAO.listarTodos();
    }

    public void atualizarFornecedor(int id, String nome, String telefone, String email) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new Exception("Nome inválido");
        }
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new Exception("Telefone inválido");
        }
        if (email == null || email.trim().isEmpty() || !email.contains("@")) {
            throw new Exception("Email inválido");
        }

        Fornecedor fornecedorExistente = fornecedorDAO.buscarPorId(id);
        if (fornecedorExistente == null) {
            throw new Exception("Fornecedor não encontrado");
        }

        fornecedorExistente.setNOME(nome);
        fornecedorExistente.setTELEFONE(telefone);
        fornecedorExistente.setEMAIL(email);

        fornecedorDAO.atualizar(fornecedorExistente);
    }

    public void deletarFornecedor(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }

        Fornecedor fornecedor = fornecedorDAO.buscarPorId(id);
        if (fornecedor == null) {
            throw new Exception("Fornecedor não encontrado");
        }

        fornecedorDAO.deletar(id);
    }
}

