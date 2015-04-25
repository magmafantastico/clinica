/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.procedimento;

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
public class ProcedimentoDAOHibernate implements ProcedimentoDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Procedimento procedimento) {
        this.session.save(procedimento);
    }

    @Override
    public void atualizar(Procedimento procedimento) {
        this.session.merge(procedimento);
    }

    @Override
    public void excluir(Procedimento procedimento) {
        this.session.delete(procedimento);
    }

    @Override
    public Procedimento carregar(Integer codigo) {
        return (Procedimento) this.session.get(Procedimento.class, codigo);
    }

    @Override
    public List<Procedimento> listarPorNome(String nome) {
        List<Procedimento> lista;
        Criteria resultado = this.session.createCriteria(Procedimento.class).add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nome"));
        lista = resultado.list();
        //for (int i = 0; i < lista.size(); i++) {
        //    System.out.println("nome === " + lista.get(i).getNome());
        // }
        //session.close();
        return lista;
    }

    @Override
    public List<Procedimento> listar() {
        Criteria l = this.session.createCriteria(Procedimento.class).addOrder(Order.asc("nome"));
        List<Procedimento> lista = l.list();
        return lista;
    }
}
