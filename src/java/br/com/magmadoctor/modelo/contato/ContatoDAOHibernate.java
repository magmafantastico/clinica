/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.contato;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class ContatoDAOHibernate implements ContatoDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Contato contato) {
        this.session.save(contato);
    }

    @Override
    public void atualizar(Contato contato) {
        this.session.update(contato);
    }

    @Override
    public void excluir(Contato contato) {
        this.session.delete(contato);
    }

    @Override
    public Contato porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Contato.class).add(Restrictions.eq("id", id));
        Contato contato = (Contato) criteria.uniqueResult();
        return contato;
    }

    @Override
    public List<Contato> listarTodos() {
        return this.session.createCriteria(Contato.class).list();
    }

}
