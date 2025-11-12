package ucb.aplicativo.dao.PagamentoPix;

import ucb.aplicativo.model.PagamentoPix;
import java.util.List;

public interface PagamentoPixDAO {

    // C - CREATE
    void salvar(PagamentoPix pagamentoPix) throws Exception;

    // R - READ
    PagamentoPix buscarPorId(int idPagamentoPix) throws Exception;

    // Buscar por chave PIX
    PagamentoPix buscarPorChavePix(String chavePix) throws Exception;

    // Listar todos
    List<PagamentoPix> listarTodos() throws Exception;

    // U - UPDATE
    void atualizar(PagamentoPix pagamentoPix) throws Exception;

    // D - DELETE
    void deletar(int idPagamentoPix) throws Exception;
}
