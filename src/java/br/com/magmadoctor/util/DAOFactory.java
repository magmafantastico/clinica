package br.com.magmadoctor.util;

import br.com.magmadoctor.modelo.agenda.AgendaDAO;
import br.com.magmadoctor.modelo.agenda.AgendaDAOHibernate;
import br.com.magmadoctor.modelo.anamnese.AnamneseDAO;
import br.com.magmadoctor.modelo.anamnese.AnamneseDAOHibernate;
import br.com.magmadoctor.modelo.categoria.CategoriaDAO;
import br.com.magmadoctor.modelo.categoria.CategoriaDAOHibernate;
import br.com.magmadoctor.modelo.cid10.CidDAO;
import br.com.magmadoctor.modelo.cid10.CidDAOHibernate;
import br.com.magmadoctor.modelo.contato.ContatoDAO;
import br.com.magmadoctor.modelo.contato.ContatoDAOHibernate;
import br.com.magmadoctor.modelo.convenio.ConvenioDAO;
import br.com.magmadoctor.modelo.convenio.ConvenioDAOHibernate;
import br.com.magmadoctor.modelo.documento.DocumentoDAO;
import br.com.magmadoctor.modelo.documento.DocumentoDAOHibernate;
import br.com.magmadoctor.modelo.email.EmailDAO;
import br.com.magmadoctor.modelo.email.EmailDAOHibernate;
import br.com.magmadoctor.modelo.empresa.EmpresaDAO;
import br.com.magmadoctor.modelo.empresa.EmpresaDAOHibernate;
import br.com.magmadoctor.modelo.endereco.EnderecoDAO;
import br.com.magmadoctor.modelo.endereco.EnderecoDAOHibernate;
import br.com.magmadoctor.modelo.especialidade.EspecialidadeDAO;
import br.com.magmadoctor.modelo.especialidade.EspecialidadeDAOHibernate;
import br.com.magmadoctor.modelo.estadoMunicipio.EstadoMunicipioDAO;
import br.com.magmadoctor.modelo.estadoMunicipio.EstadoMunicipioDAOHibernate;
import br.com.magmadoctor.modelo.paciente.PacienteDAO;
import br.com.magmadoctor.modelo.paciente.PacienteDAOHibernate;
import br.com.magmadoctor.modelo.procedimento.ProcedimentoDAO;
import br.com.magmadoctor.modelo.procedimento.ProcedimentoDAOHibernate;
import br.com.magmadoctor.modelo.profissional.ProfissionalDAO;
import br.com.magmadoctor.modelo.profissional.ProfissionalDAOHibernate;
import br.com.magmadoctor.modelo.sala.SalaDAO;
import br.com.magmadoctor.modelo.sala.SalaDAOHibernate;
import br.com.magmadoctor.modelo.salaEspera.SalaEsperaDAO;
import br.com.magmadoctor.modelo.salaEspera.SalaEsperaDAOHibernate;
import br.com.magmadoctor.modelo.usuario.UsuarioDAO;
import br.com.magmadoctor.modelo.usuario.UsuarioDAOHibernate;

/**
 *
 * @author Dirceu Junior
 */
public class DAOFactory {

   public static PacienteDAO criarPacienteDAO() {
      PacienteDAOHibernate pacienteDAO = new PacienteDAOHibernate();
      pacienteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return pacienteDAO;
   }

   public static EstadoMunicipioDAO criarEstadoMunicipioDAO() {
      EstadoMunicipioDAOHibernate estMunDAO = new EstadoMunicipioDAOHibernate();
      estMunDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return estMunDAO;
   }

   public static CategoriaDAO criarCategoriaDAO() {
      CategoriaDAOHibernate categoriaDAO = new CategoriaDAOHibernate();
      categoriaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return categoriaDAO;
   }

   public static ProcedimentoDAO criarProcedimentoDAO() {
      ProcedimentoDAOHibernate procedimentoDAO = new ProcedimentoDAOHibernate();
      procedimentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return procedimentoDAO;
   }

   public static EspecialidadeDAO criarEspecialidadeDAO() {
      EspecialidadeDAOHibernate especialidadeDAO = new EspecialidadeDAOHibernate();
      especialidadeDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return especialidadeDAO;
   }

   public static CidDAO criarCidDAO() {
      CidDAOHibernate cidDAO = new CidDAOHibernate();
      cidDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return cidDAO;
   }

   public static EnderecoDAO criarEnderecoDAO() {
      EnderecoDAOHibernate enderecoDAO = new EnderecoDAOHibernate();
      enderecoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return enderecoDAO;
   }

   public static ConvenioDAO criarConvenioDAO() {
      ConvenioDAOHibernate convenioDAO = new ConvenioDAOHibernate();
      convenioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return convenioDAO;
   }

   public static ProfissionalDAO criarProfissionalDAO() {
      ProfissionalDAOHibernate profissionalDAO = new ProfissionalDAOHibernate();
      profissionalDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return profissionalDAO;
   }

   public static AnamneseDAO criarAnamneseDAO() {
      AnamneseDAOHibernate questionarioDAO = new AnamneseDAOHibernate();
      questionarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return questionarioDAO;
   }

   public static SalaDAO criarSalaDAO() {
      SalaDAOHibernate salaDAO = new SalaDAOHibernate();
      salaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return salaDAO;
   }

   public static EmpresaDAO criarEmpresaDAO() {
      EmpresaDAOHibernate empresaDAO = new EmpresaDAOHibernate();
      empresaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return empresaDAO;
   }

   public static AgendaDAO criarAgendaDAO() {
      AgendaDAOHibernate agendaDAO = new AgendaDAOHibernate();
      agendaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return agendaDAO;
   }

   public static ContatoDAO criarContatoDAO() {
      ContatoDAOHibernate contatoDAO = new ContatoDAOHibernate();
      contatoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return contatoDAO;
   }

   public static EmailDAO criarEmailDAO() {
      EmailDAOHibernate emailDAO = new EmailDAOHibernate();
      emailDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return emailDAO;
   }

   public static DocumentoDAO criarDocumentoDAO() {
      DocumentoDAOHibernate documentoDAO = new DocumentoDAOHibernate();
      documentoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return documentoDAO;
   }

   public static UsuarioDAO criarUsuarioDAO() {
      UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
      usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return usuarioDAO;
   }

   public static SalaEsperaDAO criarSalaEsperaDAO() {
      SalaEsperaDAOHibernate salaEsperaDAO = new SalaEsperaDAOHibernate();
      salaEsperaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
      return salaEsperaDAO;
   }

}
