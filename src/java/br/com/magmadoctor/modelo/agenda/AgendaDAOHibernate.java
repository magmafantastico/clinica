/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.agenda;

import br.com.magmadoctor.modelo.profissional.Profissional;
import br.com.magmadoctor.util.DateFunctions;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class AgendaDAOHibernate implements AgendaDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Agenda agenda) {
        this.session.save(agenda);
    }

    @Override
    public void atualizar(Agenda agenda) {
        this.session.update(agenda);
    }

    @Override
    public void excluir(Agenda agenda) {
        session.delete(agenda);
    }

    @Override
    public List<Agenda> listarTodos() {
        return this.session.createCriteria(Agenda.class).addOrder(Order.asc("dtHrIniAg")).list();
    }

    @Override
    public List<Agenda> listarPorNome(String nome) {
        return this.session.createCriteria(Agenda.class).add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nome")).list();
    }

    @Override
    public Integer retornaUltimoCodigo() {
        int ultimo = 0;
        Criteria criteria = this.session.createCriteria(Agenda.class).setProjection(Projections.max("id"));
        if (criteria.uniqueResult() == null) {
            return ultimo;
        } else {
            ultimo = (Integer) criteria.uniqueResult();
        }
        return ultimo;
    }

    @Override
    public Agenda porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Agenda.class).add(Restrictions.eq("id", id));
        Agenda agenda = (Agenda) criteria.uniqueResult();
        return agenda;
    }

    @Override
    public List<Agenda> listarPorProfissional(Profissional profissional) {
        List<Agenda> lista;// = new ArrayList<>();
        lista = this.session.createCriteria(Agenda.class).add(Restrictions.eq("profissional", profissional)).addOrder(Order.asc("dtHrIniAg")).list();
        return lista;
    }

    @Override
    public List<Agenda> listarPorProfissionalData(Profissional profissional, Date data) {
        Date dataInicial = new Timestamp(data.getTime());
        Date dataFinal = new Timestamp(data.getTime());
        List<Agenda> lista = new ArrayList<>();
        Criteria criteria = this.session.createCriteria(Agenda.class)
                .add(Restrictions.between("dtHrIniAg",
                                DateFunctions.lowDateTime(dataInicial),
                                DateFunctions.highDateTime(dataFinal)))
                .add(Restrictions.eq("profissional", profissional))
                .addOrder(Order.asc("dtHrIniAg"));
        lista = criteria.list();
        return lista;
    }

    @Override
    public List<Agenda> listarPorData(Date data) {
        Date dataInicial = new Timestamp(data.getTime());
        Date dataFinal = new Timestamp(data.getTime());
        List<Agenda> lista = new ArrayList<>();
        Criteria criteria = this.session.createCriteria(Agenda.class)
                .add(Restrictions.between("dtHrIniAg",
                                DateFunctions.lowDateTime(dataInicial),
                                DateFunctions.highDateTime(dataFinal)))
                .addOrder(Order.asc("dtHrIniAg"));
        lista = criteria.list();
        return lista;
    }

}
