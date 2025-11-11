package ucb.aplicativo.control;

import java.util.List;
import ucb.aplicativo.dao.produto.ProdutoDAO;
import ucb.aplicativo.dao.produto.ProdutoDAOMySQL;
import ucb.aplicativo.model.Produto;

public class ProdutoControl {

    private final ProdutoDAO produtoDAO;

    public ProdutoControl() {
        this.produtoDAO = new ProdutoDAOMySQL();
    }

    // Cadastrar novo produto
    public void cadastrarProduto(Produto produto) throws Exception {
        produtoDAO.salvar(produto);
        System.out.println("✅ Produto cadastrado com sucesso!");
    }

    // Buscar produto por ID
    public Produto buscarProdutoPorId(Long id) throws Exception {
        return produtoDAO.buscarPorId(id);
    }

    // Buscar produto por nome
    public List<Produto> buscarProdutoPorNome(String nome) throws Exception {
        return produtoDAO.buscarPorNome(nome);
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos() throws Exception {
        return produtoDAO.listarTodos();
    }

    // Atualizar produto
    public void atualizarProduto(Produto produto) throws Exception {
        produtoDAO.atualizar(produto);
        System.out.println("🔄 Produto atualizado com sucesso!");
    }

    // Deletar produto
    public void deletarProduto(Long id) throws Exception {
        produtoDAO.deletar(id);
        System.out.println("🗑️ Produto removido com sucesso!");
    }
}