/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.dao;
import java.sql.Connection;

/**
 *
 * @author JOAO
 */
public interface ConnectionBD {
    Connection obterConexao() throws Exception;

    void fecharConexao(Connection conexao);
}