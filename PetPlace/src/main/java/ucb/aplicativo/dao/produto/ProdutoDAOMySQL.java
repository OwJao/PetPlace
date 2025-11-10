package ucb.aplicativo.dao.produto;

import ucb.aplicativo.dao.ConnectionBD;
import ucb.aplicativo.dao.ConnectionMySQL;
import ucb.aplicativo.model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAOMySQL implements ProdutoDAO {
    private ConnectionBD fabricaDeConexao;

    public ProdutoDAOMySQL() {
        this.fabricaDeConexao = new ConnectionMySQL();
    }

    @Override
    public void salvar(Produto produto) throws Exception {

        String sql = "INSERT INTO produto (nome, descricao, preco, estoque) VALUES (?, ?, ?, ?)";
        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidadeEstoque());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    produto.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao salvar produto: " + e.getMessage(), e);
        }
    }

    @Override
    public Produto buscarPorId(Long id) throws Exception {
        String sql = "SELECT * FROM produto WHERE id = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);

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
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
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
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, estoque = ? WHERE id = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setBigDecimal(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidadeEstoque());
            stmt.setLong(5, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }
    @Override
    public void deletar(Long id) throws Exception {
        String sql = "DELETE FROM produto WHERE id = ?";

        try (Connection conexao = fabricaDeConexao.obterConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new Exception("Erro ao deletar produto: " + e.getMessage(), e);
        }
    }

    private Produto buildProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();

        produto.setId(rs.getLong("id"));
        produto.setNome(rs.getString("nome"));
        produto.setPreco(rs.getBigDecimal("preco"));
        produto.setQuantidadeEstoque(rs.getInt("estoque"));

        return produto;
    }
}