/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.especialidade;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class EspecialidadeDAOHibernate implements EspecialidadeDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Especialidade cliente) {
        this.session.save(cliente);
    }

    @Override
    public void atualizar(Especialidade cliente) {
        this.session.update(cliente);
    }

    @Override
    public void excluir(Especialidade cliente) {
        session.delete(cliente);
    }

    @Override
    public List<Especialidade> listarTodos() {
        return this.session.createCriteria(Especialidade.class).addOrder(Order.asc("nome")).list();
    }

    @Override
    public List<Especialidade> listarPorNome(String nome) {
        return this.session.createCriteria(Especialidade.class).add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nome")).list();
    }

    @Override
    public Especialidade porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Especialidade.class).add(Restrictions.eq("id", id));
        Especialidade especialidade = (Especialidade) criteria.uniqueResult();
        return especialidade;
    }

    @Override
    public Especialidade porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Especialidade.class).add(Restrictions.eq("nome", nome));
        Especialidade especialidade = (Especialidade) criteria.uniqueResult();
        return especialidade;
    }

}
