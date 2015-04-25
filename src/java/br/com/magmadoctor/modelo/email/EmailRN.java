/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.email;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class EmailRN {

    private final EmailDAO emailDAO;

    public EmailRN() {
        this.emailDAO = DAOFactory.criarEmailDAO();
    }

    public void salvar(Email email) {
        this.emailDAO.salvar(email);
    }

    public void atualizar(Email email) {
        this.emailDAO.atualizar(email);
    }

    public void excluir(Email email) {
        this.emailDAO.excluir(email);
    }

    public List<Email> listarTodos() {
        return this.emailDAO.listarTodos();
    }

    public List<Email> listarPorNome(String nome) {
        return this.emailDAO.listarPorNome(nome);
    }

    public Email porId(int id) {
        return this.emailDAO.porId(id);
    }

    public Email porNome(String nome) {
        return this.emailDAO.porNome(nome);
    }

}
