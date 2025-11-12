package ucb.aplicativo.dao.serviço;

// Imports necessários para a conexão, se tirar dá erro!
import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Servico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAOMySQL implements ServicoDAO {

    private ConnectionBD fabricaDeConexao;

    public ServicoDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    // C - CREATE
    @Override
    public void salvar(Servico servico) throws Exception {
        String sql = "INSERT INTO SERVICO (PRECO, BANHO, TOSA) VALUES (?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setBigDecimal(1, servico.getPRECO());
            stmt.setInt(2, servico.getBANHO());
            stmt.setInt(3, servico.getTOSA());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    servico.setIdSERVICO(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar servico: " + e.getMessage(), e);
        }
    }

    // R - READ
    @Override
    public Servico buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM SERVICO WHERE idSERVICO = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildServico(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar servico por ID: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ
    @Override
    public List<Servico> listarTodos() throws Exception {
        String sql = "SELECT * FROM SERVICO";
        List<Servico> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(buildServico(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar servicos: " + e.getMessage(), e);
        }
        return lista;
    }

    // R - READ
    @Override
    public List<Servico> listarPorBanho(int banho) throws Exception {
        String sql = "SELECT * FROM SERVICO WHERE BANHO = ?";
        List<Servico> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, banho);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(buildServico(rs));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar servicos por banho: " + e.getMessage(), e);
        }
        return lista;
    }

    // U - UPDATE
    @Override
    public void atualizar(Servico servico) throws Exception {
        String sql = "UPDATE SERVICO SET PRECO = ?, BANHO = ?, TOSA = ? WHERE idSERVICO = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setBigDecimal(1, servico.getPRECO());
            stmt.setInt(2, servico.getBANHO());
            stmt.setInt(3, servico.getTOSA()); // Erro 't' corrigido aqui
            stmt.setInt(4, servico.getIdSERVICO());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar servico: " + e.getMessage(), e);
        }
    }

    // D - DELETE
    @Override
    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM SERVICO WHERE idSERVICO = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar servico: " + e.getMessage(), e);
        }
    }


    private Servico buildServico(ResultSet rs) throws SQLException {
        Servico servico = new Servico();

        servico.setIdSERVICO(rs.getInt("idSERVICO"));
        servico.setPRECO(rs.getBigDecimal("PRECO"));
        servico.setBANHO(rs.getInt("BANHO"));
        servico.setTOSA(rs.getInt("TOSA"));

        return servico;
    }
}