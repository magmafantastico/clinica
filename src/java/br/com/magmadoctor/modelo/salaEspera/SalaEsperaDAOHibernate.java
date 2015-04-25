/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.salaEspera;

import br.com.magmadoctor.modelo.profissional.Profissional;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Dirceu Junior
 */
public class SalaEsperaDAOHibernate implements SalaEsperaDAO {

   private Session session;

   public void setSession(Session session) {
      this.session = session;
   }

   @Override
   public void salvar(SalaEspera salaEspera) {
      this.session.save(salaEspera);
   }

   @Override
   public void atualizar(SalaEspera salaEspera) {
      this.session.update(salaEspera);
   }

   @Override
   public void excluir(SalaEspera salaEspera) {
      session.delete(salaEspera);
   }

   @Override
   public List<SalaEspera> listarTodos() {
      return this.session.createCriteria(SalaEspera.class).addOrder(Order.asc("dataHoraEntrada")).list();
      //return this.session.createCriteria(SalaEspera.class).list();//.addOrder(Order.asc("id")).list();
   }

   @Override
   public SalaEspera porId(Integer id) {
      Criteria criteria = this.session.createCriteria(SalaEspera.class).add(Restrictions.eq("id", id));
      SalaEspera salaEspera = (SalaEspera) criteria.uniqueResult();
      return salaEspera;
   }

}
