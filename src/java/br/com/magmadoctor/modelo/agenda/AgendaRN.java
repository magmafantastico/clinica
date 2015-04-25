/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.agenda;

import br.com.magmadoctor.modelo.profissional.Profissional;
import br.com.magmadoctor.util.DAOFactory;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class AgendaRN {

   private final AgendaDAO agendaDAO;

   public AgendaRN() {
      this.agendaDAO = DAOFactory.criarAgendaDAO();
   }

   public void salvar(Agenda agenda) {
      this.agendaDAO.salvar(agenda);
   }

   public void atualizar(Agenda agenda) {
      this.agendaDAO.atualizar(agenda);
   }

   public void excluir(Agenda agenda) {
      this.agendaDAO.excluir(agenda);
   }

   public List<Agenda> listarTodos() {
      return this.agendaDAO.listarTodos();
   }

   public List<Agenda> listarPorNome(String nome) {
      return this.agendaDAO.listarPorNome(nome);
   }

   public int buscaUltimoRegistro() {
      return this.agendaDAO.retornaUltimoCodigo();
   }

   public Agenda porId(int id) {
      return this.agendaDAO.porId(id);
   }

   public List<Agenda> listarPorProfissional(Profissional profissional) {
      return this.agendaDAO.listarPorProfissional(profissional);
   }

   public List<Agenda> listarPorProfissionalData(Profissional profissional, Date data) {
      return this.agendaDAO.listarPorProfissionalData(profissional, data);
   }

   public List<Agenda> listarPorData(Date data) {
      return this.agendaDAO.listarPorData(data);
   }

}
