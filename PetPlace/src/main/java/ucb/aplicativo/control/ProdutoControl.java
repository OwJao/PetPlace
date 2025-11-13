/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import ucb.aplicativo.dao.produto.ProdutoDAO;
import ucb.aplicativo.dao.produto.ProdutoDAOMySQL;
import ucb.aplicativo.model.Produto;
import java.util.List;

/**
 *
 * @author Gustavo NF
 */


public class ProdutoControl {

    private ProdutoDAO produtoDAO;

    public ProdutoControl() {
        this.produtoDAO = new ProdutoDAOMySQL();
    }

    public void cadastrarProduto(Produto produto) throws Exception {
        if (produto.getNOME() == null || produto.getNOME().isEmpty()) {
            throw new Exception("O nome do produto é obrigatório.");
        }
        if (produto.getPRECO() == null || produto.getPRECO().doubleValue() <= 0) {
            throw new Exception("O preço deve ser maior que zero.");
        }
        produtoDAO.salvar(produto);
    }

    public Produto buscarPorId(Long id) throws Exception {
        Produto produto = produtoDAO.buscarPorId(id);
        if (produto == null) {
            throw new Exception("Produto não encontrado.");
        }
        return produto;
    }

    public List<Produto> listarTodos() throws Exception {
        return produtoDAO.listarTodos();
    }

    public void atualizarProduto(Produto produto) throws Exception {
        if (produto.getIdPRODUTO() <= 0) {
            throw new Exception("ID inválido para atualização.");
        }
        produtoDAO.atualizar(produto);
    }

    public void deletarProduto(Long id) throws Exception {
        produtoDAO.deletar(id);
    }
}

