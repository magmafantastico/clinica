
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.empresa;

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
public class EmpresaDAOHibernate implements EmpresaDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Empresa empresa) {
        this.session.save(empresa);
    }

    @Override
    public void atualizar(Empresa empresa) {
        this.session.update(empresa);
    }

    @Override
    public void excluir(Empresa empresa) {
        this.session.delete(empresa);
    }

    @Override
    public List<Empresa> listarPorNome(String nome) {
        List<Empresa> lista;
        Criteria resultado = this.session.createCriteria(Empresa.class).add(Restrictions.like("nomeFantasia", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("nomeFantasia"));
        lista = resultado.list();
        return lista;
    }

    @Override
    public List<Empresa> listarTodos() {
        List<Empresa> lista;
        Criteria resultado = this.session.createCriteria(Empresa.class).addOrder(Order.asc("nomeFantasia"));
        lista = resultado.list();
        return lista;
    }

}
