/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.documento;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class DocumentoDAOHibernate implements DocumentoDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Documento documento) {
        this.session.save(documento);
    }

    @Override
    public void atualizar(Documento documento) {
        this.session.update(documento);
    }

    @Override
    public void excluir(Documento documento) {
        this.session.delete(documento);
    }

    @Override
    public Documento porId(Integer id) {
        Criteria criteria = this.session.createCriteria(Documento.class).add(Restrictions.eq("id", id));
        Documento documento = (Documento) criteria.uniqueResult();
        return documento;
    }

}
