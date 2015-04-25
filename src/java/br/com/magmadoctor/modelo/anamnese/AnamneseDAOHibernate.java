/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.anamnese;

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
public class AnamneseDAOHibernate implements AnamneseDAO {

    private Session session;

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public void salvar(Anamnese questionario) {
        this.session.save(questionario);
    }

    @Override
    public void atualizar(Anamnese questionario) {
        this.session.update(questionario);
    }

    @Override
    public void excluir(Anamnese questionario) {
        session.delete(questionario);
    }

    @Override
    public List<Anamnese> listarTodos() {
        return this.session.createCriteria(Anamnese.class).addOrder(Order.asc("questao")).list();
    }

    @Override
    public Integer retornaUltimoCodigo() {
        int ultimo = 0;
        Criteria criteria = this.session.createCriteria(Anamnese.class).setProjection(Projections.max("codigo"));
        if (criteria.uniqueResult() == null) {
            return ultimo;
        } else {
            ultimo = (Integer) criteria.uniqueResult();
        }
        return ultimo;
    }

    @Override
    public Anamnese porCodigo(Integer codigo) {
        Criteria criteria = this.session.createCriteria(Anamnese.class).add(Restrictions.eq("codigo", codigo));
        Anamnese paciente = (Anamnese) criteria.uniqueResult();
        return paciente;
    }

    @Override
    public Anamnese porNome(String nome) {
        Criteria criteria = this.session.createCriteria(Anamnese.class).add(Restrictions.eq("nome", nome));
        Anamnese paciente = (Anamnese) criteria.uniqueResult();
        return paciente;
    }

}
