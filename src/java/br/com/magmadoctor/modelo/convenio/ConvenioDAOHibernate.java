
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.convenio;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Aguinaldo
 */
public class ConvenioDAOHibernate implements ConvenioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Convenio convenio) {
        this.session.save(convenio);
    }

    @Override
    public void atualizar(Convenio convenio) {
        this.session.update(convenio);
    }

    @Override
    public void excluir(Convenio convenio) {
        this.session.delete(convenio);
    }

    @Override
    public List<Convenio> listarPorNome(String nome) {
        List<Convenio> lista;
        Criteria resultado = this.session.createCriteria(Convenio.class).add(Restrictions.like("nomeFantasia", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nomeFantasia"));
        lista = resultado.list();
        return lista;
    }

    @Override
    public List<Convenio> listarTodos() {
        List<Convenio> lista;
        Criteria resultado = this.session.createCriteria(Convenio.class).addOrder(Order.asc("nomeFantasia"));
        lista = resultado.list();
        return lista;
    }

    @Override
    public Convenio porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Convenio.class).add(Restrictions.eq("nomeFantasia", nome));
        Convenio convenio = (Convenio) criteria.uniqueResult();
        return convenio;
    }
    
    @Override
    public Convenio porId (Integer id) {
        Criteria criteria = this.session.createCriteria(Convenio.class).add(Restrictions.eq("id", id));
        Convenio convenio = (Convenio) criteria.uniqueResult();
        return convenio;
    }

}
