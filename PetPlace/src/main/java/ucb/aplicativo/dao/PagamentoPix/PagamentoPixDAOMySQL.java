package ucb.aplicativo.dao.PagamentoPix;

import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.PagamentoPix;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PagamentoPixDAOMySQL implements PagamentoPixDAO {

    private final ConnectionBD fabricaDeConexao;

    public PagamentoPixDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    // C - CREATE
    @Override
    public void salvar(PagamentoPix pagamentoPix) throws Exception {
        String sql = "INSERT INTO PAGAMENTO_PIX (idPAGAMENTO_PIX, CHAVE_PIX, ID_COMPRA) VALUES (?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, pagamentoPix.getIdPAGAMENTO_PIX());
            stmt.setString(2, pagamentoPix.getCHAVE_PIX());
            stmt.setInt(3, pagamentoPix.getID_COMPRA());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao salvar PagamentoPix: " + e.getMessage(), e);
        }
    }

    // R - READ
    @Override
    public PagamentoPix buscarPorId(int idPagamentoPix) throws Exception {
        String sql = "SELECT * FROM PAGAMENTO_PIX WHERE idPAGAMENTO_PIX = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idPagamentoPix);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildPagamentoPix(rs);
                }
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao buscar PagamentoPix por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public PagamentoPix buscarPorChavePix(String chavePix) throws Exception {
        String sql = "SELECT * FROM PAGAMENTO_PIX WHERE CHAVE_PIX = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, chavePix);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildPagamentoPix(rs);
                }
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao buscar PagamentoPix por chave PIX: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ ALL
    @Override
    public List<PagamentoPix> listarTodos() throws Exception {
        String sql = "SELECT * FROM PAGAMENTO_PIX";
        List<PagamentoPix> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(buildPagamentoPix(rs));
            }

        } catch (SQLException e) {
            throw new Exception("Erro ao listar PagamentosPix: " + e.getMessage(), e);
        }
        return lista;
    }

    // U - UPDATE
    @Override
    public void atualizar(PagamentoPix pagamentoPix) throws Exception {
        String sql = "UPDATE PAGAMENTO_PIX SET CHAVE_PIX = ?, ID_COMPRA = ? WHERE idPAGAMENTO_PIX = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, pagamentoPix.getCHAVE_PIX());
            stmt.setInt(2, pagamentoPix.getID_COMPRA());
            stmt.setInt(3, pagamentoPix.getIdPAGAMENTO_PIX());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar PagamentoPix: " + e.getMessage(), e);
        }
    }

    // D - DELETE
    @Override
    public void deletar(int idPagamentoPix) throws Exception {
        String sql = "DELETE FROM PAGAMENTO_PIX WHERE idPAGAMENTO_PIX = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idPagamentoPix);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar PagamentoPix: " + e.getMessage(), e);
        }
    }

    // Método auxiliar
    private PagamentoPix buildPagamentoPix(ResultSet rs) throws SQLException {
        PagamentoPix pagamentoPix = new PagamentoPix();

        pagamentoPix.setIdPAGAMENTO_PIX(rs.getInt("idPAGAMENTO_PIX"));
        pagamentoPix.setCHAVE_PIX(rs.getString("CHAVE_PIX"));
        pagamentoPix.setID_COMPRA(rs.getInt("ID_COMPRA"));

        return pagamentoPix;
    }
}