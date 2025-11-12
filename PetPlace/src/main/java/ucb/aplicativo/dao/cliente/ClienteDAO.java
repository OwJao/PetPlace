
package ucb.aplicativo.dao.cliente;

import ucb.aplicativo.model.Cliente;
import java.util.List;


public interface ClienteDAO {


    void salvar(Cliente cliente) throws Exception;


    Cliente buscarPorCpf(String cpf) throws Exception; // Agora é busca principal
    Cliente buscarPorEmail(String email) throws Exception;
    List<Cliente> listarTodos() throws Exception;


    void atualizar(Cliente cliente) throws Exception;


    void deletar(String cpf) throws Exception; // Deleta pelo CPF
}