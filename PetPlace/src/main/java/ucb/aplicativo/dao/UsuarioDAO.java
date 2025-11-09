// Em: ucb.aplicativo.dao.UsuarioDAO.java
package ucb.aplicativo.dao;

import java.util.List;


public interface UsuarioDAO {

    // Criação
    void salvar(Usuario usuario) throws Exception;

    // Para leitura
    Usuario buscarPorEmail(String email) throws Exception;
    Usuario buscarPorId(Long id) throws Exception; // Alterado para Long
    List<Usuario> listarTodos() throws Exception;

    // Update
    void atualizar(Usuario usuario) throws Exception;

    // Para Deletar
    void deletar(Long id) throws Exception;
}