
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

    @Override
    public void salvar(Cliente cliente) throws Exception {
        String sql = "INSERT INTO usuario " +
                "(nome, email, senha, tipoUsuario, cpf, telefone, endereco) " +
                "VALUES (?, ?, ?, 'CLIENTE', ?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEndereco());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar cliente: " + e.getMessage(), e);
        }
    }
    @Override
    public Cliente buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM usuario WHERE id = ? AND tipoUsuario = 'CLIENTE'";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setLong(1, id);
                        try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                return buildCliente(rs);
                            }
                        }
                            } catch (SQLException e) {
                                throw new Exception("Erro ao buscar cliente por ID: " + e.getMessage(), e);
                            }
                            return null;
    }

    //Read- Para listar CPF
    @Override
    public Cliente buscarPorCpf(String cpf) throws Exception {
        String sql = "SELECT * FROM usuario WHERE cpf = ? AND tipoUsuario = 'CLIENTE'";

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

   // Read- Para listar os email
    @Override
    public Cliente buscarPorEmail(String email) throws Exception {
        String sql = "SELECT * FROM usuario WHERE email = ? AND tipoUsuario = 'CLIENTE'";

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

  // Read também, Só que para listar tudo
    @Override
    public List<Cliente> listarTodos() throws Exception {
        String sql = "SELECT * FROM usuario WHERE tipoUsuario = 'CLIENTE'";
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

  //Update
    @Override
    public void atualizar(Cliente cliente) throws Exception {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, " +
                "cpf = ?, telefone = ?, endereco = ? " +
                "WHERE id = ? AND tipoUsuario = 'CLIENTE'";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, cliente.getSenha());
            stmt.setString(4, cliente.getCpf());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEndereco());
            stmt.setLong(7, cliente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar cliente: " + e.getMessage(), e);
        }
    }

   // Delete
    @Override
    public void deletar(Long id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id = ? AND tipoUsuario = 'CLIENTE'";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar cliente: " + e.getMessage(), e);
        }
    }

    private Cliente buildCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente();

        // Dados do usuario
        cliente.setId(rs.getLong("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEmail(rs.getString("email"));
        cliente.setSenha(rs.getString("senha"));
        cliente.setTipoUsuario(rs.getString("tipoUsuario"));

        // Dados do cliente
        cliente.setCpf(rs.getString("cpf"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setEndereco(rs.getString("endereco"));

        return cliente;
    }
}