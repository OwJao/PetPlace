package ucb.aplicativo.dao.produto;


import ucb.aplicativo.model.Produto;
import java.util.List;

public interface ProdutoDAO {

    // Criar
    void salvar(Produto produto) throws Exception;


    // Ler
    Produto buscarPorId(Long id) throws Exception;
    List<Produto> buscarPorNome(String nome) throws Exception;
    List<Produto> listarTodos() throws Exception;

    // Atualizar
    void atualizar(Produto produto) throws Exception;

    // Deletar
    void deletar(Long id) throws Exception;
}