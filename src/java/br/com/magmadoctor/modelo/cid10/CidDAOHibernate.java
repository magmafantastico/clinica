/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.cid10;

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
public class CidDAOHibernate implements CidDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Cid cid) {
        this.session.save(cid);
    }

    @Override
    public void atualizar(Cid cid) {
        this.session.merge(cid);
    }

    @Override
    public void excluir(Cid cid) {
        this.session.delete(cid);
    }

    @Override
    public List<Cid> listarTodos() {
        Criteria l = this.session.createCriteria(Cid.class).addOrder(Order.asc("descricao"));
        List<Cid> lista = l.list();
        return lista;

    }

    @Override
    public List<Cid> listarPorNome(String nome) {
        List<Cid> lista;
        Criteria resultado = this.session.createCriteria(Cid.class);
        resultado.add(Restrictions.like("descricao", nome, MatchMode.ANYWHERE));
        resultado.addOrder(Order.asc("descricao"));
        lista = resultado.list();
        return lista;
    }

}
