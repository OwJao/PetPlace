
package ucb.aplicativo.dao.cliente;

import ucb.aplicativo.model.Cliente;
import java.util.List;

public interface ClienteDAO {

    // Create
    void salvar(Cliente cliente) throws Exception;

    // Read
    Cliente buscarPorId(Long id) throws Exception;
    Cliente buscarPorCpf(String cpf) throws Exception;
    Cliente buscarPorEmail(String email) throws Exception;
    List<Cliente> listarTodos() throws Exception;

    // Update
    void atualizar(Cliente cliente) throws Exception;

    // Delete
    void deletar(Long id) throws Exception;
}