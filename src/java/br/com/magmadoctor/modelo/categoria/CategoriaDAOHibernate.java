/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.categoria;

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
public class CategoriaDAOHibernate implements CategoriaDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    /**
     *
     * @param categoria
     */
    @Override
    public void salvar(Categoria categoria) {
        session.save(categoria);
    }

    @Override
    public void atualizar(Categoria categoria) {
        session.merge(categoria);
    }

    @Override
    public void excluir(Categoria categoria) {
        session.delete(categoria);
    }

    @Override
    public List<Categoria> listarTodos() {
        try {
            Criteria l = this.session.createCriteria(Categoria.class).addOrder(Order.asc("nome"));
            List<Categoria> lista = l.list();
            return lista;
        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            //close();
        }
        return null;
    }

    @Override
    public List<Categoria> listarPorNome(String nome) {
        try {
            session.getTransaction().begin();
            List<Categoria> lista;
            Criteria resultado = this.session.createCriteria(Categoria.class).add(Restrictions.like("nome", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nome"));
            lista = resultado.list();
            session.getTransaction().commit();
            return lista;
        } catch (Throwable t) {
            session.getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
        return null;
    }

    @Override
    public int retornaUltimoCodigo() {
        try {
            int ultimo = 0;
            session.getTransaction().begin();
            Criteria criteria = this.session.createCriteria(Categoria.class).setProjection(Projections.max("codigo"));
            if (criteria.uniqueResult() == null) {
                return ultimo;
            } else {
//                ultimo = (int) criteria.uniqueResult();
            }
            session.getTransaction().commit();
            return ultimo;
        } catch (Throwable t) {
            session.getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
        return 0;
    }

    @Override
    public Categoria retornaCategoriaPorCodigo(int codigo) {
        Criteria criteria = this.session.createCriteria(Categoria.class).add(Restrictions.eq("codigo", codigo));
        Categoria categoria = (Categoria) criteria.uniqueResult();
        return categoria;
    }

    private void close() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

}
