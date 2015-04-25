/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.endereco;

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
public class EnderecoDAOHibernate implements EnderecoDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Endereco endereco) {
        this.session.save(endereco);
    }

    @Override
    public void atualizar(Endereco endereco) {
        this.session.update(endereco);
    }

    @Override
    public void excluir(Endereco endereco) {
        this.session.delete(endereco);
    }

    @Override
    public Endereco porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Endereco.class).add(Restrictions.eq("id", id));
        Endereco endereco = (Endereco) criteria.uniqueResult();
        return endereco;
    }

    @Override
    public Endereco porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Endereco.class).add(Restrictions.eq("logradouro", nome));
        Endereco endereco = (Endereco) criteria.uniqueResult();
        return endereco;
    }

    @Override
    public List<Endereco> listarTodos() {
        return this.session.createCriteria(Endereco.class).addOrder(Order.asc("logradouro")).list();
    }

    @Override
    public List<Endereco> listarPorNome(String nome) {
        return this.session.createCriteria(Endereco.class).add(Restrictions.like("logradouro", nome, MatchMode.ANYWHERE)).addOrder(Order.asc("logradouro")).list();
    }

    @Override
    public Integer retornaUltimoCodigo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
