/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.agenda;

import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.especialidade.Especialidade;
import br.com.magmadoctor.modelo.paciente.Paciente;
import br.com.magmadoctor.modelo.profissional.Profissional;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Agenda implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dtHrIniAg;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dtHrFimAg;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dtHrChegada;

   private String statusChegada;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dtHrIniAt;

   @Temporal(javax.persistence.TemporalType.TIMESTAMP)
   private Date dtHrFimAt;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "paciente_codigo")
   private Paciente paciente;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "convenio_codigo")
   private Convenio convenio;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "profissional_codigo")
   private Profissional profissional;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "especialidade_codigo")
   private Especialidade especialidade;

   private String notasAgenda;

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Date getDtHrIniAg() {
      return dtHrIniAg;
   }

   public void setDtHrIniAg(Date dtHrIniAg) {
      this.dtHrIniAg = dtHrIniAg;
   }

   public Date getDtHrFimAg() {
      return dtHrFimAg;
   }

   public void setDtHrFimAg(Date dtHrFimAg) {
      this.dtHrFimAg = dtHrFimAg;
   }

   public Date getDtHrChegada() {
      return dtHrChegada;
   }

   public void setDtHrChegada(Date dtHrChegada) {
      this.dtHrChegada = dtHrChegada;
   }

   public Date getDtHrIniAt() {
      return dtHrIniAt;
   }

   public void setDtHrIniAt(Date dtHrIniAt) {
      this.dtHrIniAt = dtHrIniAt;
   }

   public Date getDtHrFimAt() {
      return dtHrFimAt;
   }

   public void setDtHrFimAt(Date dtHrFimAt) {
      this.dtHrFimAt = dtHrFimAt;
   }

   public Paciente getPaciente() {
      return paciente;
   }

   public void setPaciente(Paciente paciente) {
      this.paciente = paciente;
   }

   public Convenio getConvenio() {
      return convenio;
   }

   public void setConvenio(Convenio convenio) {
      this.convenio = convenio;
   }

   public Profissional getProfissional() {
      return profissional;
   }

   public void setProfissional(Profissional profissional) {
      this.profissional = profissional;
   }

   public Especialidade getEspecialidade() {
      return especialidade;
   }

   public void setEspecialidade(Especialidade especialidade) {
      this.especialidade = especialidade;
   }

   public String getNotasAgenda() {
      return notasAgenda;
   }

   public void setNotasAgenda(String notasAgenda) {
      this.notasAgenda = notasAgenda;
   }

   public String getStatusChegada() {
      return statusChegada;
   }

   public void setStatusChegada(String statusChegada) {
      this.statusChegada = statusChegada;
   }

}
