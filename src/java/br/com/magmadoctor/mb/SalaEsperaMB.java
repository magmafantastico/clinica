/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.agenda.Agenda;
import br.com.magmadoctor.modelo.paciente.PacienteRN;
import br.com.magmadoctor.modelo.salaEspera.SalaEspera;
import br.com.magmadoctor.modelo.salaEspera.SalaEsperaRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aguinaldo
 */
@ManagedBean
@ViewScoped
public class SalaEsperaMB {

   private SalaEspera salaEspera = new SalaEspera();
   private Agenda agenda = new Agenda();
   private List<SalaEspera> listarTodos;
   private String pagina;

   public SalaEsperaMB() {
      this.pagina = "sala";
      salaEspera = new SalaEspera();
   }

   public SalaEspera getSalaEspera() {
      return salaEspera;
   }

   public void setSalaEspera(SalaEspera salaEspera) {
      this.salaEspera = salaEspera;
   }

   public String novo() {
      this.salaEspera = new SalaEspera();
      return pagina;
   }

   public String inserir() {
      SalaEsperaRN seRN = new SalaEsperaRN();
      if (this.salaEspera.getId() != null && this.salaEspera.getId() != 0) {
         seRN.atualizar(getSalaEspera());
         FacesMessage msg = new FacesMessage("SALA ATUALIZADA COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         seRN.salvar(getSalaEspera());
         novo();
         FacesMessage msg = new FacesMessage("SALA CADASTRADA COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return pagina;
   }

   public String excluir() {
      SalaEsperaRN seRN = new SalaEsperaRN();
      if (this.salaEspera.getId() != null && this.salaEspera.getId() != 0) {
         seRN.excluir(getSalaEspera());
         FacesMessage msg = new FacesMessage("SALA EXCLUIDA COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         FacesMessage msg = new FacesMessage("FAVOR SELECIONAR SALA PARA EXCLUSÃO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return pagina;
   }

//   public void setListarTodos(List<SalaEspera> listarTodos) {
//      this.listarTodos = listarTodos;
//   }
//
//   public List<SalaEspera> getListarTodos() {
//      SalaEsperaRN seRN = new SalaEsperaRN();
//      return seRN.listarTodos();
//   }
   public void adicionarSalaEspera() {
      SalaEsperaRN sRN = new SalaEsperaRN();
      salaEspera.setAgenda(agenda);
      sRN.salvar(salaEspera);
   }

   public Agenda getAgenda() {
      return agenda;
   }

   public void setAgenda(Agenda agenda) {
      this.agenda = agenda;
   }

   public String getPagina() {
      return pagina;
   }

   public void setPagina(String pagina) {
      this.pagina = pagina;
   }

   public List<SalaEspera> getListarTodos() {
      SalaEsperaRN seRN = new SalaEsperaRN();
      return seRN.listarTodos();
   }

   public void setListarTodos(List<SalaEspera> listarTodos) {
      this.listarTodos = listarTodos;
   }

}
