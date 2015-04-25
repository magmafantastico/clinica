/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.estadoMunicipio;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class EstadoMunicipioDAOHibernate implements EstadoMunicipioDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<Estado> listarEstados() {
        Criteria l = this.session.createCriteria(Estado.class).addOrder(Order.asc("nome"));
        List<Estado> lista = l.list();
        return lista;
    }

    @Override
    public List<Municipio> listarMunicipios() {
        return this.session.createCriteria(Municipio.class).addOrder(Order.asc("nome")).list();
    }

    @Override
    public List<Municipio> buscarPorUF(Integer id) {
        Criteria criteria = this.session.createCriteria(Municipio.class);
        criteria.add(Restrictions.eq("estado_id", String.valueOf(id)));
        return criteria.list();
    }
}
