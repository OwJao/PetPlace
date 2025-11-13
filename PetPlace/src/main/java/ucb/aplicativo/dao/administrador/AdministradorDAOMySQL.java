package ucb.aplicativo.dao.administrador;
import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Administrador;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAOMySQL implements AdministradorDAO {

    private final ConnectionBD fabricaDeConexao;

    public AdministradorDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    // C - CREATE (Salvar)
    @Override
    public void salvar(Administrador admin) throws Exception {
        String sql = "INSERT INTO ADMINISTRADOR (NOME, LOGIN, SENHA) VALUES (?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, admin.getNOME());
            stmt.setString(2, admin.getLOGIN());
            stmt.setString(3, admin.getSENHA());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    admin.setIdADMINISTRADOR(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar administrador: " + e.getMessage(), e);
        }
    }

    // R - READ (Buscar por ID)
    @Override
    public Administrador buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM ADMINISTRADOR WHERE idADMINISTRADOR = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildAdministrador(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar admin por ID: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ (Buscar por Login)
    @Override
    public Administrador buscarPorLogin(String login) throws Exception {
        String sql = "SELECT * FROM ADMINISTRADOR WHERE LOGIN = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, login);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildAdministrador(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar admin por login: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ (Listar Todos)
    @Override
    public List<Administrador> listarTodos() throws Exception {
        String sql = "SELECT * FROM ADMINISTRADOR";
        List<Administrador> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(buildAdministrador(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar administradores: " + e.getMessage(), e);
        }
        return lista;
    }

    // U - UPDATE (Atualizar)
    @Override
    public void atualizar(Administrador admin) throws Exception {
        String sql = "UPDATE ADMINISTRADOR SET NOME = ?, LOGIN = ?, SENHA = ? WHERE idADMINISTRADOR = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, admin.getNOME());
            stmt.setString(2, admin.getLOGIN());
            stmt.setString(3, admin.getSENHA());
            stmt.setInt(4, admin.getIdADMINISTRADOR());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar admin: " + e.getMessage(), e);
        }
    }

    // D - DELETE (Deletar)
    @Override
    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM ADMINISTRADOR WHERE idADMINISTRADOR = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar admin: " + e.getMessage(), e);
        }
    }


    private Administrador buildAdministrador(ResultSet rs) throws SQLException {
        Administrador admin = new Administrador();

        admin.setIdADMINISTRADOR(rs.getInt("idADMINISTRADOR"));
        admin.setNOME(rs.getString("NOME"));
        admin.setLOGIN(rs.getString("LOGIN"));
        admin.setSENHA(rs.getString("SENHA"));

        return admin;
    }
}