package ucb.aplicativo.dao.serviço;

import ucb.aplicativo.model.Servico;
import java.util.List;

public interface ServicoDAO {

    // CREATE
    void salvar(Servico servico) throws Exception;

    //  READ
    Servico buscarPorId(int id) throws Exception;
    List<Servico> listarTodos() throws Exception;

    // READ- Listar todos que oferecem banho por exemplo
    List<Servico> listarPorBanho(int banho) throws Exception;

    // UPDATE
    void atualizar(Servico servico) throws Exception;

    // DELETE
    void deletar(int id) throws Exception;
}