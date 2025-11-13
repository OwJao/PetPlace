package ucb.aplicativo.dao.compra;

import ucb.aplicativo.model.Compra;
import java.util.List;

public interface CompraDAO {

    // create
    void salvar(Compra compra) throws Exception;

    // read
    Compra buscarPorId(int id) throws Exception;
    List<Compra> listarTodos() throws Exception;

    // read- mais útil para controller
    List<Compra> buscarPorCpf(String cpf) throws Exception;

    // update
    void atualizar(Compra compra) throws Exception;

    // delete
    void deletar(int id) throws Exception;
}