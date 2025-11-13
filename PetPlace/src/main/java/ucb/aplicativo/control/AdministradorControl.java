/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.control;

import ucb.aplicativo.dao.administrador.AdministradorDAO;
import ucb.aplicativo.dao.administrador.AdministradorDAOMySQL;
import ucb.aplicativo.model.Administrador;
import java.util.List;

/**
 *
 * @author Gustavo NF
 */


public class AdministradorControl {

    private AdministradorDAO administradorDAO;

    public AdministradorControl() {
        this.administradorDAO = new AdministradorDAOMySQL();
    }

    public void cadastrarAdministrador(Administrador admin) throws Exception {
        if (admin.getNOME() == null || admin.getNOME().isEmpty()) {
            throw new Exception("Nome não pode ser vazio.");
        }
        if (admin.getLOGIN() == null || admin.getLOGIN().isEmpty()) {
            throw new Exception("Login não pode ser vazio.");
        }
        if (admin.getSENHA() == null || admin.getSENHA().isEmpty()) {
            throw new Exception("Senha não pode ser vazia.");
        }

        Administrador existente = administradorDAO.buscarPorLogin(admin.getLOGIN());
        if (existente != null) {
            throw new Exception("Já existe um administrador com este login.");
        }

        administradorDAO.salvar(admin);
    }

    public Administrador buscarPorId(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido.");
        }
        Administrador admin = administradorDAO.buscarPorId(id);
        if (admin == null) {
            throw new Exception("Administrador não encontrado.");
        }
        return admin;
    }

    public Administrador login(String login, String senha) throws Exception {
        if (login == null || login.isEmpty() || senha == null || senha.isEmpty()) {
            throw new Exception("Login e senha são obrigatórios.");
        }

        Administrador admin = administradorDAO.buscarPorLogin(login);
        if (admin == null || !admin.getSENHA().equals(senha)) {
            throw new Exception("Login ou senha incorretos.");
        }

        return admin;
    }

    public List<Administrador> listarAdministradores() throws Exception {
        return administradorDAO.listarTodos();
    }

    public void atualizarAdministrador(Administrador admin) throws Exception {
        if (admin.getIdADMINISTRADOR() <= 0) {
            throw new Exception("ID inválido para atualização.");
        }
        administradorDAO.atualizar(admin);
    }

    public void deletarAdministrador(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido.");
        }
        administradorDAO.deletar(id);
    }
}

