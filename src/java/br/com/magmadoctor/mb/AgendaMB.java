/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.agenda.Agenda;
import br.com.magmadoctor.modelo.agenda.AgendaRN;
import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.convenio.ConvenioRN;
import br.com.magmadoctor.modelo.especialidade.Especialidade;
import br.com.magmadoctor.modelo.especialidade.EspecialidadeRN;
import br.com.magmadoctor.modelo.paciente.Paciente;
import br.com.magmadoctor.modelo.paciente.PacienteRN;
import br.com.magmadoctor.modelo.profissional.Profissional;
import br.com.magmadoctor.modelo.profissional.ProfissionalRN;
import br.com.magmadoctor.util.DateFunctions;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author vmseven
 */
@ManagedBean
@ViewScoped
public class AgendaMB implements Serializable {

   private Agenda agenda = new Agenda();
   private Paciente paciente = new Paciente();
   private Profissional profissional = new Profissional();
   private Convenio convenio = new Convenio();
   private Especialidade especialidade = new Especialidade();

   private List<Agenda> listarTodos;
   private List<Agenda> listarPorProfissional;

   private List<Convenio> convenios = new ArrayList<>();
   private List<Especialidade> especialidades = new ArrayList<>();

   private Integer profissionalSelecionado;
   private Integer controlaAgenda;

   private String pagina;
   private String mensagemAgenda;

   private ScheduleModel eventModel;

   private String dataSelecionada;

   private String lenght;

   private String iconePresente;

   private String iconeAusente;

   public AgendaMB() {
      this.controlaAgenda = 0;
      this.lenght = "00:30";
      this.pagina = "teste";
      this.iconeAusente = "icon-square-o";
      this.iconePresente = "icon-check-square-o";
      listarAgendaCompleta();
      inicializar();
   }

   public String inserir() {
      AgendaRN aRN = new AgendaRN();
      if (this.agenda.getId() != null && this.agenda.getId() != 0) {
         processSchedule();
         processEndDate();
         aRN.atualizar(getAgenda());
         FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      } else {
         processSchedule();
         processEndDate();
         agenda.setStatusChegada(getIconeAusente());
         aRN.salvar(getAgenda());
         FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
         FacesContext.getCurrentInstance().addMessage(null, msg);
      }
      return getPagina();
   }

   public void novo() {
      agenda = new Agenda();
      paciente = new Paciente();
      profissional = new Profissional();
      especialidades.clear();
      convenios.clear();
   }

   public void processSchedule() {
      agenda.setPaciente(paciente);
      agenda.setProfissional(profissional);
      agenda.setEspecialidade(especialidade);
      agenda.setConvenio(convenio);
   }

   public void processEndDate() {
      Calendar endDate = Calendar.getInstance();
      Calendar time = Calendar.getInstance();
      try {
         SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm");
         time.setTime(formatHour.parse(getLenght()));
      } catch (ParseException e) {
         System.out.println("Erro -> " + e.toString());
      }
      endDate.setTime(agenda.getDtHrIniAg());
      endDate.add(Calendar.HOUR_OF_DAY, time.get(Calendar.HOUR));
      endDate.add(Calendar.MINUTE, time.get(Calendar.MINUTE));
      agenda.setDtHrFimAg(endDate.getTime());
   }

   public void carregaAgenda() {
      AgendaRN aRN = new AgendaRN();
      agenda = aRN.porId(agenda.getId());
      if (agenda.getPaciente() != null) {
         PacienteRN pRN = new PacienteRN();
         paciente = pRN.porId(agenda.getPaciente().getId());
      }
      if (agenda.getConvenio() != null) {
         ConvenioRN cRN = new ConvenioRN();
         convenio = cRN.porId(agenda.getConvenio().getId());
      }
      if (agenda.getProfissional() != null) {
         ProfissionalRN pfRN = new ProfissionalRN();
         profissional = pfRN.porId(agenda.getProfissional().getId());
      }
      if (agenda.getEspecialidade() != null) {
         EspecialidadeRN eRN = new EspecialidadeRN();
         especialidade = eRN.porId(agenda.getEspecialidade().getId());
      }
      especialidades.clear();
      especialidades.addAll(profissional.getEspecialidades());
      convenios.clear();
      convenios.addAll(paciente.getConvenios());
   }

   private void inicializar() {
      AgendaRN aRN = new AgendaRN();
      listarTodos = aRN.listarTodos();
      eventModel = new DefaultScheduleModel();
      gerarCalendario(listarTodos);
      listarTodos.clear();
   }

   public void gerarCalendario(List<Agenda> agendamentos) {
      eventModel.clear();
      for (Agenda ag : agendamentos) {
         DefaultScheduleEvent evento = new DefaultScheduleEvent();
         evento.setStartDate(ag.getDtHrIniAg());
         evento.setEndDate(ag.getDtHrFimAg());
         evento.setTitle(ag.getPaciente().getNome() + " (" + ag.getProfissional().getNome() + ")");
         evento.setData(ag.getId());
         evento.setEditable(true);
         evento.setStyleClass(ag.getProfissional().getColor());
         eventModel.addEvent(evento);
      }
   }

   public void quandoNovo(SelectEvent selectEvent) {
      DateFunctions df = new DateFunctions();
      Calendar dtAtual = Calendar.getInstance();
      Calendar dtEscolhida = Calendar.getInstance();
      ScheduleEvent event = new DefaultScheduleEvent("",
              (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
      dtEscolhida.setTime(event.getStartDate());
      agenda = new Agenda();
      paciente = new Paciente();
      profissional = new Profissional();
      especialidades.clear();
      convenios.clear();
      if (df.comparaData(dtEscolhida, dtAtual) != -1) {
         mensagemAgenda = null;
         agenda.setDtHrIniAg(event.getStartDate());
      } else {
         mensagemAgenda = "NÃO PERMITIDO AGENDAR COM DATA RETROATIVA \n ALTERADO PARA DATA ATUAL";
         agenda.setDtHrIniAg(dtAtual.getTime());
      }
   }

   public void quandoSelecionado(SelectEvent selectEvent) {
      mensagemAgenda = null;
      ScheduleEvent event = (ScheduleEvent) selectEvent.getObject();
      AgendaRN aRN = new AgendaRN();
      int escolhido = (Integer) (event.getData());
      agenda = aRN.porId(escolhido);
      if (agenda.getPaciente() != null) {
         PacienteRN pRN = new PacienteRN();
         paciente = pRN.porId(agenda.getPaciente().getId());
      }
      if (agenda.getConvenio() != null) {
         ConvenioRN cRN = new ConvenioRN();
         convenio = cRN.porId(agenda.getConvenio().getId());
      }
      if (agenda.getProfissional() != null) {
         ProfissionalRN pfRN = new ProfissionalRN();
         profissional = pfRN.porId(agenda.getProfissional().getId());
      }
      if (agenda.getEspecialidade() != null) {
         EspecialidadeRN eRN = new EspecialidadeRN();
         especialidade = eRN.porId(agenda.getEspecialidade().getId());
      }
      especialidades.clear();
      especialidades.addAll(profissional.getEspecialidades());
      convenios.clear();
      convenios.addAll(paciente.getConvenios());
   }

   public void quandoMovido(ScheduleEntryMoveEvent event) {
      AgendaRN aRN = new AgendaRN();
      int escolhido = (Integer) (event.getScheduleEvent().getData());
      agenda = aRN.porId(escolhido);
      Date dataAtual = Calendar.getInstance().getTime();
      Date dataAgendada = agenda.getDtHrIniAg();
      Date dataAlterada = calcularNovaData(agenda.getDtHrIniAg(), event.getDayDelta());
      //agenda.setDataAtendimento(calcularNovaData(agenda.getDataAtendimento(), event.getDayDelta()));
      if (dataAlterada.before(dataAtual)) {
         FacesMessage msg = new FacesMessage("NÃO PERMITIDO - ALTERAÇÃO NÃO REALIZADA");
         FacesContext.getCurrentInstance().addMessage(null, msg);
         agenda.setDtHrIniAg(dataAgendada);
      } else {
         FacesMessage msg = new FacesMessage("ALTERAÇÃO EFETUADA COM SUCESSO");
         FacesContext.getCurrentInstance().addMessage(null, msg);
         agenda.setDtHrIniAg(dataAlterada);
      }
      if (agenda.getPaciente() != null) {
         PacienteRN pRN = new PacienteRN();
         paciente = pRN.porId(agenda.getPaciente().getId());
      }
      if (agenda.getConvenio() != null) {
         ConvenioRN cRN = new ConvenioRN();
         convenio = cRN.porId(agenda.getConvenio().getId());
      }
      if (agenda.getProfissional() != null) {
         ProfissionalRN pfRN = new ProfissionalRN();
         profissional = pfRN.porId(agenda.getProfissional().getId());
      }
      if (agenda.getEspecialidade() != null) {
         EspecialidadeRN eRN = new EspecialidadeRN();
         especialidade = eRN.porId(agenda.getEspecialidade().getId());
      }
   }

   public Date calcularNovaData(Date atual, int dias) {
      Calendar c = Calendar.getInstance();
      c.setTime(atual);
      c.add(Calendar.DAY_OF_YEAR, dias);
      return c.getTime();
   }

   public void conveniosPorPaciente(SelectEvent event) {
      convenios.clear();
      paciente = (Paciente) event.getObject();
      convenios.addAll(paciente.getConvenios());
   }

   public void especialidadesPorProfissional(SelectEvent event) {
      especialidades.clear();
      profissional = (Profissional) event.getObject();
      especialidades.addAll(profissional.getEspecialidades());
   }

   public List<Agenda> getListarTodos() {
      AgendaRN aRN = new AgendaRN();
      listarTodos = aRN.listarTodos();
      return listarTodos;
   }

   public void agendaProfissional(ValueChangeEvent event) throws Exception {
      AgendaRN aRN = new AgendaRN();
      ProfissionalRN pRN = new ProfissionalRN();
      listarPorProfissional.clear();
      profissionalSelecionado = Integer.parseInt(event.getNewValue().toString());
      if (profissionalSelecionado != 0) {
         setControlaAgenda(0);
         profissional = pRN.porId(profissionalSelecionado);
         if (dataSelecionada == null) {
            listarPorProfissional = aRN.listarPorProfissional(profissional);
            gerarCalendario(listarPorProfissional);
         } else {
            listarPorProfissional = aRN.listarPorProfissionalData(profissional, DateFunctions.formataData(getDataSelecionada()));
         }
      } else {
         setControlaAgenda(1);
         listarPorProfissional = aRN.listarTodos();
         gerarCalendario(listarPorProfissional);
      }
   }

   public void agendaPorData() throws Exception {
      AgendaRN aRN = new AgendaRN();
      ProfissionalRN pRN = new ProfissionalRN();
      listarPorProfissional.clear();
      if (controlaAgenda == 1) {
         listarPorProfissional = aRN.listarPorData(DateFunctions.formataData(getDataSelecionada()));
      } else {
         profissional = pRN.porId(profissionalSelecionado);
         listarPorProfissional = aRN.listarPorProfissionalData(profissional, DateFunctions.formataData(getDataSelecionada()));
      }

   }

   public void adicionarSalaEspera() {
      AgendaRN aRN = new AgendaRN();
      carregaAgenda();
      agenda.setDtHrChegada(Calendar.getInstance().getTime());
      if (agenda.getStatusChegada().equals(getIconeAusente())) {
         agenda.setStatusChegada(getIconePresente());
      } else {
         agenda.setStatusChegada(getIconeAusente());
      }
      inserir();
   }

   private void listarAgendaCompleta() {
      AgendaRN aRN = new AgendaRN();
      listarPorProfissional = aRN.listarTodos();
   }

   public void setListarTodos(List<Agenda> listarTodos) {
      this.listarTodos = listarTodos;
   }

   public Agenda getAgenda() {
      return agenda;
   }

   public void setAgenda(Agenda agenda) {
      this.agenda = agenda;
   }

   public Paciente getPaciente() {
      return paciente;
   }

   public void setPaciente(Paciente paciente) {
      this.paciente = paciente;
   }

   public Profissional getProfissional() {
      return profissional;
   }

   public void setProfissional(Profissional profissional) {
      this.profissional = profissional;
   }

   public Convenio getConvenio() {
      return convenio;
   }

   public void setConvenio(Convenio convenio) {
      this.convenio = convenio;
   }

   public Especialidade getEspecialidade() {
      return especialidade;
   }

   public void setEspecialidade(Especialidade especialidade) {
      this.especialidade = especialidade;
   }

   public String getPagina() {
      return pagina;
   }

   public void setPagina(String pagina) {
      this.pagina = pagina;
   }

   public Integer getProfissionalSelecionado() {
      return profissionalSelecionado;
   }

   public void setProfissionalSelecionado(Integer profissionalSelecionado) {
      this.profissionalSelecionado = profissionalSelecionado;
   }

   public List<Agenda> getListarPorProfissional() {
      return listarPorProfissional;
   }

   public void setListarPorProfissional(List<Agenda> listarPorProfissional) {
      this.listarPorProfissional = listarPorProfissional;
   }

   public List<Convenio> getConvenios() {
      return convenios;
   }

   public void setConvenios(List<Convenio> convenios) {
      this.convenios = convenios;
   }

   public List<Especialidade> getEspecialidades() {
      return especialidades;
   }

   public void setEspecialidades(List<Especialidade> especialidades) {
      this.especialidades = especialidades;
   }

   public ScheduleModel getEventModel() {
      return eventModel;
   }

   public void setEventModel(ScheduleModel eventModel) {
      this.eventModel = eventModel;
   }

   public String getMensagemAgenda() {
      return mensagemAgenda;
   }

   public void setMensagemAgenda(String mensagemAgenda) {
      this.mensagemAgenda = mensagemAgenda;
   }

   public String getDataSelecionada() {
      return dataSelecionada;
   }

   public void setDataSelecionada(String dataSelecionada) {
      this.dataSelecionada = dataSelecionada;
   }

   public Integer getControlaAgenda() {
      return controlaAgenda;
   }

   public void setControlaAgenda(Integer controlaAgenda) {
      this.controlaAgenda = controlaAgenda;
   }

   public String getLenght() {
      return lenght;
   }

   public void setLenght(String lenght) {
      this.lenght = lenght;
   }

   public String getIconePresente() {
      return iconePresente;
   }

   public void setIconePresente(String iconePresente) {
      this.iconePresente = iconePresente;
   }

   public String getIconeAusente() {
      return iconeAusente;
   }

   public void setIconeAusente(String iconeAusente) {
      this.iconeAusente = iconeAusente;
   }

}
