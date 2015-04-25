/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.profissional;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aguinaldo
 */
public class ProfissionalDAOHibernate implements ProfissionalDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Profissional profissional) {
        this.session.save(profissional);
    }

    @Override
    public void atualizar(Profissional profissional) {
        this.session.update(profissional);
    }

    @Override
    public void excluir(Profissional profissional) {
        this.session.delete(profissional);
    }

    @Override
    public Profissional porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Profissional.class).add(Restrictions.eq("id", id));
        Profissional profissional = (Profissional) criteria.uniqueResult();
        return profissional;
    }

    @Override
    public Profissional porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Profissional.class).add(Restrictions.eq("nome", nome));
        Profissional profissional = (Profissional) criteria.uniqueResult();
        return profissional;
    }

    @Override
    public List<Profissional> listarPorNome(String nome) {
        return this.session.createCriteria(Profissional.class).add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nome")).list();
    }

    @Override
    public List<Profissional> listarPorEspecilizacao(String especializacao) {
        return this.session.createCriteria(Profissional.class).add(Restrictions.like("nome", especializacao, MatchMode.ANYWHERE)).addOrder(Order.asc("nome")).list();
    }

    @Override
    public List<Profissional> listarTodos() {
        return this.session.createCriteria(Profissional.class).addOrder(Order.asc("nome")).list();
    }

    @Override
    public Integer retornaUltimoCodigo() {
        int ultimo = 0;
        Criteria criteria = this.session.createCriteria(Profissional.class).setProjection(Projections.max("id"));
        if (criteria.uniqueResult() == null) {
            return ultimo;
        } else {
            ultimo = (Integer) criteria.uniqueResult();
        }
        return ultimo;
    }
}
