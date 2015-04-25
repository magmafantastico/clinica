/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.paciente;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class PacienteRN {

   private final PacienteDAO pacienteDAO;

   public PacienteRN() {
      this.pacienteDAO = DAOFactory.criarPacienteDAO();
   }

   public void salvar(Paciente cliente) {
      this.pacienteDAO.salvar(cliente);
   }

   public void atualizar(Paciente cliente) {
      this.pacienteDAO.atualizar(cliente);
   }

   public void excluir(Paciente cliente) {
      this.pacienteDAO.excluir(cliente);
   }

   public List<Paciente> listarTodos() {
      return this.pacienteDAO.listarTodos();
   }

   public List<Paciente> listarPorNome(String nome) {
      return this.pacienteDAO.listarPorNome(nome);
   }

   public int buscaUltimoRegistro() {
      return this.pacienteDAO.retornaUltimoId();
   }

   public Paciente porId(int id) {
      return this.pacienteDAO.porId(id);
   }

   public Paciente porNome(String nome) {
      return this.pacienteDAO.porNome(nome);
   }

   public Paciente porCPF(String cpf) {
      return this.pacienteDAO.porCPF(cpf);
   }

   public List<Paciente> porNomeSimples(String nome) {
      return this.pacienteDAO.porNomeSimples(nome);
   }
}
