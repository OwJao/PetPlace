package ucb.aplicativo.dao.Fornecedor;

import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Fornecedor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAOMySQL implements FornecedorDAO {

    private final ConnectionBD fabricaDeConexao;

    public FornecedorDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    // C - CREATE
    @Override
    public void salvar(Fornecedor fornecedor) throws Exception {
        String sql = "INSERT INTO FORNECEDOR (NOME, TELEFONE, EMAIL) VALUES (?, ?, ?)";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, fornecedor.getNOME());
            ps.setString(2, fornecedor.getTELEFONE());
            ps.setString(3, fornecedor.getEMAIL());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao salvar fornecedor: " + e.getMessage(), e);
        }
    }

    // R - READ
    @Override
    public Fornecedor buscarPorId(int idFORNECEDOR) throws Exception {
        String sql = "SELECT * FROM FORNECEDOR WHERE idFORNECEDOR = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, idFORNECEDOR);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildFornecedor(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar fornecedor por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public Fornecedor buscarPorEmail(String EMAIL) throws Exception {
        String sql = "SELECT * FROM FORNECEDOR WHERE EMAIL = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, EMAIL);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return buildFornecedor(rs);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar fornecedor por email: " + e.getMessage(), e);
        }
        return null;
    }

    // R - READ (listar todos)
    @Override
    public List<Fornecedor> listarTodos() throws Exception {
        String sql = "SELECT * FROM FORNECEDOR";
        List<Fornecedor> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                lista.add(buildFornecedor(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar fornecedores: " + e.getMessage(), e);
        }
        return lista;
    }

    // U - UPDATE
    @Override
    public void atualizar(Fornecedor fornecedor) throws Exception {
        String sql = "UPDATE FORNECEDOR SET NOME = ?, TELEFONE = ?, EMAIL = ? WHERE idFORNECEDOR = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, fornecedor.getNOME());
            ps.setString(2, fornecedor.getTELEFONE());
            ps.setString(3, fornecedor.getEMAIL());
            ps.setInt(4, fornecedor.getIdFORNECEDOR());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar fornecedor: " + e.getMessage(), e);
        }
    }

    // D - DELETE
    @Override
    public void deletar(int idFORNECEDOR) throws Exception {
        String sql = "DELETE FROM FORNECEDOR WHERE idFORNECEDOR = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setInt(1, idFORNECEDOR);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar fornecedor: " + e.getMessage(), e);
        }
    }

    // Método auxiliar para montar o objeto
    private Fornecedor buildFornecedor(ResultSet rs) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setIdFORNECEDOR(rs.getInt("idFORNECEDOR"));
        fornecedor.setNOME(rs.getString("NOME"));
        fornecedor.setTELEFONE(rs.getString("TELEFONE"));
        fornecedor.setEMAIL(rs.getString("EMAIL"));
        return fornecedor;
    }
}