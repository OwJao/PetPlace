package ucb.aplicativo.dao.usuario;

import ucb.aplicativo.model.Usuario;
import java.util.List;



public interface UsuarioDAO {

    // Para Create
    void salvar(Usuario usuario) throws Exception;

    // Para Read
    Usuario buscarPorEmail(String email) throws Exception;
    Usuario buscarPorId(Long id) throws Exception; // Alterado para Long
    List<Usuario> listarTodos() throws Exception;

    // Para Update
    void atualizar(Usuario usuario) throws Exception;

    // Para Delete
    void deletar(Long id) throws Exception;
}