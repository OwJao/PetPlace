package ucb.aplicativo.dao;

import java.sql.*; // Importar tudo de sql
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements UsuarioDAO {

    private ConnectionBD fabricaDeConexao;

    public UsuarioDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    @Override
    public void salvar(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (nome, email, senha, tipoUsuario) VALUES (?, ?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipoUsuario());

            stmt.executeUpdate();

            // Pega o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getLong(1));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar usuário: " + e.getMessage());
            throw new Exception("Erro ao salvar usuário no banco.", e);
        }
    }

    @Override
    public Usuario buscarPorEmail(String email) throws Exception {
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Se achou, cria o usuário e retorna
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                    return usuario;
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por e-mail: " + e.getMessage());
            throw new Exception("Erro ao buscar usuário no banco.", e);
        }

        return null;
    }

    @Override
    public Usuario buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getLong("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setTipoUsuario(rs.getString("tipoUsuario"));
                    return usuario;
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário por ID: " + e.getMessage());
            throw new Exception("Erro ao buscar usuário no banco.", e);
        }

        return null;
    }

    @Override
    public List<Usuario> listarTodos() throws Exception {
        String sql = "SELECT * FROM usuario";
        List<Usuario> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Loop para pegar todos os resultados
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipoUsuario(rs.getString("tipoUsuario"));

                lista.add(usuario); // Adiciona na lista
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
            throw new Exception("Erro ao listar usuários no banco.", e);
        }

        return lista;
    }

    @Override
    public void atualizar(Usuario usuario) throws Exception {
        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, tipoUsuario = ? WHERE id = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getTipoUsuario());
            stmt.setLong(5, usuario.getId()); // ID para o WHERE

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar usuário: " + e.getMessage());
            throw new Exception("Erro ao atualizar usuário no banco.", e);
        }
    }

    @Override
    public void deletar(Long id) throws Exception {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id); // ID para o WHERE
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao deletar usuário: " + e.getMessage());
            throw new Exception("Erro ao deletar usuário no banco.", e);
        }
    }
}