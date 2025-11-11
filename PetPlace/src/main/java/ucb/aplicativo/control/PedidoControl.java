package ucb.aplicativo.control;

import java.util.List;
import ucb.aplicativo.dao.pedido.PedidoDAO;
import ucb.aplicativo.dao.pedido.PedidoDAOMySQL;
import ucb.aplicativo.model.Pedido;

public class PedidoControl {

    private final PedidoDAO pedidoDAO;

    public PedidoControl() {
        this.pedidoDAO = new PedidoDAOMySQL();
    }

    // Cadastrar novo pedido
    public void cadastrarPedido(Pedido pedido) throws Exception {
        pedidoDAO.salvar(pedido);
        System.out.println("✅ Pedido cadastrado com sucesso!");
    }

    // Buscar pedido por ID
    public Pedido buscarPedidoPorId(Long id) throws Exception {
        return pedidoDAO.buscarPorId(id);
    }

    // Listar todos os pedidos
    public List<Pedido> listarPedidos() throws Exception {
        return pedidoDAO.listarTodos();
    }

    // Atualizar pedido
    public void atualizarPedido(Pedido pedido) throws Exception {
        pedidoDAO.atualizar(pedido);
        System.out.println("🔄 Pedido atualizado com sucesso!");
    }

    // Deletar pedido
    public void deletarPedido(Long id) throws Exception {
        pedidoDAO.deletar(id);
        System.out.println("🗑️ Pedido removido com sucesso!");
    }
}