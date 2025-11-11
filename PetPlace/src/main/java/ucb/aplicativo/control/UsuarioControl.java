package ucb.aplicativo.control;

import java.util.List;
import ucb.aplicativo.dao.UsuarioDAO;
import ucb.aplicativo.dao.UsuarioDAOMySQL;
import ucb.aplicativo.model.Usuario;

public class UsuarioControl {

    private final UsuarioDAO usuarioDAO;

    public UsuarioControl() {
        this.usuarioDAO = new UsuarioDAOMySQL();
    }

    // Cadastrar novo usuário
    public void cadastrarUsuario(Usuario usuario) throws Exception {
        usuarioDAO.salvar(usuario);
        System.out.println("✅ Usuário cadastrado com sucesso!");
    }

    // Buscar usuário por e-mail
    public Usuario buscarUsuarioPorEmail(String email) throws Exception {
        return usuarioDAO.buscarPorEmail(email);
    }

    // Buscar usuário por ID
    public Usuario buscarUsuarioPorId(Long id) throws Exception {
        return usuarioDAO.buscarPorId(id);
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() throws Exception {
        return usuarioDAO.listarTodos();
    }

    // Atualizar dados do usuário
    public void atualizarUsuario(Usuario usuario) throws Exception {
        usuarioDAO.atualizar(usuario);
        System.out.println("🔄 Usuário atualizado com sucesso!");
    }

    // Deletar usuário
    public void deletarUsuario(Long id) throws Exception {
        usuarioDAO.deletar(id);
        System.out.println("🗑️ Usuário removido com sucesso!");
    }
}