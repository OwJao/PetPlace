package ucb.aplicativo.dao.produto;

import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOMySQL implements ProdutoDAO {
    private final ConnectionBD fabricaDeConexao;

    public ProdutoDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    @Override
    public void salvar(Produto produto) throws Exception {

        String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO, PRECO, QUANTIDADE_ESTOQUE) VALUES (?, ?, ?, ?)";
        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNOME());
            stmt.setString(2, produto.getDESCRICAO());
            stmt.setBigDecimal(3, produto.getPRECO());
            stmt.setInt(4, produto.getQUANTIDADE_ESTOQUE());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setIdPRODUTO((int) rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar produto: " + e.getMessage(), e);
        }
    }

    @Override
    public Produto buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM produto WHERE idPRODUTO = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    return buildProduto(rs);
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar produto por ID: " + e.getMessage(), e);
        }
        return null;
    }

    @Override
    public List<Produto> buscarPorNome(String nome) throws Exception {
        String sql = "SELECT * FROM PRODUTO WHERE NOME LIKE ?";
        List<Produto> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, "%" + nome + "%");

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    lista.add(buildProduto(rs));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar produtos por nome: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public List<Produto> listarTodos() throws Exception {
        String sql = "SELECT * FROM produto";
        List<Produto> lista = new ArrayList<>();

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(buildProduto(rs));
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao listar produtos: " + e.getMessage(), e);
        }
        return lista;
    }

    @Override
    public void atualizar(Produto produto) throws Exception {
        String sql = "UPDATE PRODUTO SET NOME = ?, DESCRICAO = ?, PRECO = ?, QUANTIDADE_ESTOQUE = ? WHERE idPRODUTO = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNOME());
            stmt.setString(2, produto.getDESCRICAO());
            stmt.setBigDecimal(3, produto.getPRECO());
            stmt.setInt(4, produto.getQUANTIDADE_ESTOQUE());
            stmt.setInt(5, produto.getIdPRODUTO());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }
    @Override
    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM PRODUTO WHERE idPRODUTO = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }

    private Produto buildProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();

        produto.setIdPRODUTO(rs.getInt("idPRODUTO"));
        produto.setNOME(rs.getString("NOME"));
        produto.setDESCRICAO(rs.getString("DESCRICAO"));
        produto.setPRECO(rs.getBigDecimal("PRECO"));
        produto.setQUANTIDADE_ESTOQUE(rs.getInt("QUANTIDADE_ESTOQUE"));

        return produto;
    }
}