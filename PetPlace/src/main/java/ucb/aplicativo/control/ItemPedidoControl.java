package ucb.aplicativo.control;

import java.util.List;
import ucb.aplicativo.dao.itempedido.ItemPedidoDAO;
import ucb.aplicativo.dao.itempedido.ItemPedidoDAOMySQL;
import ucb.aplicativo.model.ItemPedido;

public class ItemPedidoControl {

    private final ItemPedidoDAO itemPedidoDAO;

    public ItemPedidoControl() {
        this.itemPedidoDAO = new ItemPedidoDAOMySQL();
    }

    // Cadastrar novo item
    public void cadastrarItemPedido(ItemPedido itemPedido) throws Exception {
        itemPedidoDAO.salvar(itemPedido);
        System.out.println("✅ Item de pedido cadastrado com sucesso!");
    }

    // Buscar item por ID
    public ItemPedido buscarItemPorId(Long id) throws Exception {
        return itemPedidoDAO.buscarPorId(id);
    }

    // Listar itens de um pedido
    public List<ItemPedido> listarItensPorPedido(Long pedidoId) throws Exception {
        return itemPedidoDAO.listarPorPedido(pedidoId);
    }

    // Atualizar item
    public void atualizarItemPedido(ItemPedido itemPedido) throws Exception {
        itemPedidoDAO.atualizar(itemPedido);
        System.out.println("🔄 Item de pedido atualizado com sucesso!");
    }

    // Deletar item
    public void deletarItemPedido(Long id) throws Exception {
        itemPedidoDAO.deletar(id);
        System.out.println("🗑️ Item de pedido removido com sucesso!");
    }
}