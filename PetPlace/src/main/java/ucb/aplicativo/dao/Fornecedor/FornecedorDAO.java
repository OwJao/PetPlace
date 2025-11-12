package ucb.aplicativo.dao.Fornecedor;

import ucb.aplicativo.model.Fornecedor;
import java.util.List;

public interface FornecedorDAO {

    // Criação
    void salvar(Fornecedor fornecedor) throws Exception;

    // Leitura
    Fornecedor buscarPorId(int idFORNECEDOR) throws Exception;
    Fornecedor buscarPorEmail(String EMAIL) throws Exception;
    List<Fornecedor> listarTodos() throws Exception;

    // Atualização
    void atualizar(Fornecedor fornecedor) throws Exception;

    // Exclusão
    void deletar(int idFORNECEDOR) throws Exception;
}