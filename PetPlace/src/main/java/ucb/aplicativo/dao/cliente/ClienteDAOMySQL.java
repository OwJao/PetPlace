package ucb.aplicativo.dao.cliente;

import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOMySQL implements ClienteDAO {

    private ConnectionBD fabricaDeConexao;

    public ClienteDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    // C - CREATE
    @Override
    public void salvar(Cliente cliente) throws Exception {
        String sql = "INSERT INTO CLIENTE (cpf, nome, telefone, email, endereco, " +
                "compra_idCOMPRA, animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());
            stmt.setInt(6, cliente.getCompra_idCOMPRA());
            stmt.setInt(7, cliente.getAnimal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao salvar cliente: " + e.getMessage(), e);
        }
    }

    // R - READ
    @Override
    public Cliente buscarPorCpf(String cpf) throws Exception {
        String sql = "SELECT * FROM CLIENTE WHERE cpf = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar cliente por CPF: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ
    @Override
    public Cliente buscarPorEmail(String email) throws Exception {
        String sql = "SELECT * FROM CLIENTE WHERE email = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildCliente(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar cliente por Email: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ
    @Override
    public List<Cliente> listarTodos() throws Exception {
        String sql = "SELECT * FROM CLIENTE";
        List<Cliente> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(buildCliente(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar clientes: " + e.getMessage(), e);
        }
        return lista;
    }

    // U - UPDATE
    @Override
    public void atualizar(Cliente cliente) throws Exception {
        String sql = "UPDATE CLIENTE SET nome = ?, telefone = ?, email = ?, endereco = ?, " +
                "compra_idCOMPRA = ?, animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO = ? " +
                "WHERE cpf = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getEndereco());
            stmt.setInt(5, cliente.getCompra_idCOMPRA());
            stmt.setInt(6, cliente.getAnimal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO());
            stmt.setString(7, cliente.getCpf());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

    // D - DELETE
    @Override
    public void deletar(String cpf) throws Exception {
        String sql = "DELETE FROM CLIENTE WHERE cpf = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar cliente: " + e.getMessage(), e);
        }
    }


    private Cliente buildCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setCpf(rs.getString("cpf"));
        cliente.setNome(rs.getString("nome"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setEmail(rs.getString("email"));
        cliente.setEndereco(rs.getString("endereco"));
        cliente.setCompra_idCOMPRA(rs.getInt("compra_idCOMPRA"));
        cliente.setAnimal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO(rs.getInt("animal_DE_ESTIMACAO_idANIMAL_DE_ESTIMACAO"));

        return cliente;
    }
}