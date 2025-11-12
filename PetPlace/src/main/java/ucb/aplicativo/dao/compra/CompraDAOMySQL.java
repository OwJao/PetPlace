package ucb.aplicativo.dao.compra;

import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Compra;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAOMySQL implements CompraDAO {

    private ConnectionBD fabricaDeConexao;

    public CompraDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    // create da compra
    @Override
    public void salvar(Compra compra) throws Exception {
        String sql = "INSERT INTO COMPRA (CPF, DATA_COMPRA, VALOR_TOTAL, idPRODUTO, PAGAMENTO_PIX_idPAGAMENTO_PIX) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, compra.getCPF());
            stmt.setDate(2, compra.getDATA_COMPRA());
            stmt.setBigDecimal(3, compra.getVALOR_TOTAL());
            stmt.setString(4, compra.getIdPRODUTO());
            stmt.setInt(5, compra.getPAGAMENTO_PIX_idPAGAMENTO_PIX());


            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    compra.setIdCOMPRA(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar compra: " + e.getMessage(), e);
        }
    }

    // read- Para a busca da comrpa
    @Override
    public Compra buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM COMPRA WHERE idCOMPRA = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

                 stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return buildCompra(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar compra por ID: " + e.getMessage(), e);
        }
        return null;
    }

    // read- listagem de todos
    @Override
    public List<Compra> listarTodos() throws Exception {
        String sql = "SELECT * FROM COMPRA";
        List<Compra> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(buildCompra(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar compras: " + e.getMessage(), e);
        }
        return lista;
    }

    // read- busca por cpf
    @Override
    public List<Compra> buscarPorCpf(String cpf) throws Exception {
        String sql = "SELECT * FROM COMPRA WHERE CPF = ?";
        List<Compra> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    lista.add(buildCompra(rs));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar compras por CPF: " + e.getMessage(), e);
        }
        return lista;
    }

    // Update
    @Override
    public void atualizar(Compra compra) throws Exception {
        String sql = "UPDATE COMPRA SET CPF = ?, DATA_COMPRA = ?, VALOR_TOTAL = ?, idPRODUTO = ?, " +
                "PAGAMENTO_PIX_idPAGAMENTO_PIX = ? WHERE idCOMPRA = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, compra.getCPF());
            stmt.setDate(2, compra.getDATA_COMPRA());
            stmt.setBigDecimal(3, compra.getVALOR_TOTAL());
            stmt.setString(4, compra.getIdPRODUTO());
            stmt.setInt(5, compra.getPAGAMENTO_PIX_idPAGAMENTO_PIX());
            stmt.setInt(6, compra.getIdCOMPRA());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar compra: " + e.getMessage(), e);
        }
    }

    // Delete
    @Override
    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM COMPRA WHERE idCOMPRA = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar compra: " + e.getMessage(), e);
        }
    }


    private Compra buildCompra(ResultSet rs) throws SQLException {
        Compra compra = new Compra();

        compra.setIdCOMPRA(rs.getInt("idCOMPRA"));
        compra.setCPF(rs.getString("CPF"));
        compra.setDATA_COMPRA(rs.getDate("DATA_COMPRA"));
        compra.setVALOR_TOTAL(rs.getBigDecimal("VALOR_TOTAL"));
        compra.setIdPRODUTO(rs.getString("idPRODUTO"));
        compra.setPAGAMENTO_PIX_idPAGAMENTO_PIX(rs.getInt("PAGAMENTO_PIX_idPAGAMENTO_PIX"));

        return compra;
    }
}