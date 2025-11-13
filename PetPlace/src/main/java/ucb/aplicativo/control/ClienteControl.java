
package ucb.aplicativo.control;

import ucb.aplicativo.dao.cliente.ClienteDAO;
import ucb.aplicativo.dao.cliente.ClienteDAOMySQL;
import ucb.aplicativo.model.Cliente;
import java.util.List;

public class ClienteControl {

    private ClienteDAO clienteDAO;

    public ClienteControl() {
        this.clienteDAO = new ClienteDAOMySQL();
    }

    public void cadastrarCliente(Cliente cliente) throws Exception {
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new Exception("CPF não pode ser vazio.");
        }
        if (cliente.getNome() == null || cliente.getNome().isEmpty()) {
            throw new Exception("Nome não pode ser vazio.");
        }
        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            throw new Exception("Email não pode ser vazio.");
        }

        Cliente existente = clienteDAO.buscarPorCpf(cliente.getCpf());
        if (existente != null) {
            throw new Exception("Já existe um cliente cadastrado com este CPF.");
        }

        clienteDAO.salvar(cliente);
    }

    public Cliente buscarClientePorCpf(String cpf) throws Exception {
        if (cpf == null || cpf.isEmpty()) {
            throw new Exception("CPF inválido.");
        }
        Cliente cliente = clienteDAO.buscarPorCpf(cpf);
        if (cliente == null) {
            throw new Exception("Cliente não encontrado.");
        }
        return cliente;
    }

    public List<Cliente> listarClientes() throws Exception {
        return clienteDAO.listarTodos();
    }

    public void atualizarCliente(Cliente cliente) throws Exception {
        if (cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
            throw new Exception("CPF é obrigatório para atualização.");
        }
        clienteDAO.atualizar(cliente);
    }

    public void deletarCliente(String cpf) throws Exception {
        if (cpf == null || cpf.isEmpty()) {
            throw new Exception("CPF inválido.");
        }
        clienteDAO.deletar(cpf);
    }
}
