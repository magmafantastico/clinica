/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.contato;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class ContatoRN {

    private final ContatoDAO contatoDAO;

    public ContatoRN() {
        this.contatoDAO = DAOFactory.criarContatoDAO();
    }

    public void salvar(Contato contato) {
        this.contatoDAO.salvar(contato);
    }

    public void atualizar(Contato contato) {
        this.contatoDAO.atualizar(contato);
    }

    public void excluir(Contato contato) {
        this.contatoDAO.excluir(contato);
    }

    public List<Contato> listarTodos() {
        return this.contatoDAO.listarTodos();
    }

    public Contato porId(int id) {
        return this.contatoDAO.porId(id);
    }

}
