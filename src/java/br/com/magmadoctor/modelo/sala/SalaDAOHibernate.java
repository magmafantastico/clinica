/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.magmadoctor.modelo.sala;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

/**
 *
 * @author Aguinaldo
 */
public class SalaDAOHibernate implements SalaDAO{
    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }
    
    @Override
    public void salvar(Sala sala) {
        session.save(sala);
    }

    @Override
    public void atualizar(Sala sala) {
        session.merge(sala);
    }

    @Override
    public void excluir(Sala sala) {
        session.delete(sala);
    }

    @Override
    public List<Sala> listarTodos() {
        try {
            Criteria l = this.session.createCriteria(Sala.class).addOrder(Order.asc("codigo"));
            List<Sala> lista = l.list();
            return lista;
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            //close();
        }
        return null;
    }

}
