/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.salaEspera;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class SalaEsperaRN {

   private final SalaEsperaDAO salaEsperaDAO;

   public SalaEsperaRN() {
      this.salaEsperaDAO = DAOFactory.criarSalaEsperaDAO();
   }

   public void salvar(SalaEspera salaEspera) {
      this.salaEsperaDAO.salvar(salaEspera);
   }

   public void atualizar(SalaEspera salaEspera) {
      this.salaEsperaDAO.atualizar(salaEspera);
   }

   public void excluir(SalaEspera salaEspera) {
      this.salaEsperaDAO.excluir(salaEspera);
   }

   public List<SalaEspera> listarTodos() {
      return this.salaEsperaDAO.listarTodos();
   }

   public SalaEspera porId(int id) {
      return this.salaEsperaDAO.porId(id);
   }

}
