package ucb.aplicativo.dao.administrador;
import ucb.aplicativo.model.Administrador;
import java.util.List;

public interface AdministradorDAO {

    // Create
    void salvar(Administrador admin) throws Exception;

    // Read
    Administrador buscarPorId(int id) throws Exception;

    // Método login
    Administrador buscarPorLogin(String login) throws Exception;

    List<Administrador> listarTodos() throws Exception;

    // Update
    void atualizar(Administrador admin) throws Exception;

    // Delete
    void deletar(int id) throws Exception;
}