   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.agenda;

import br.com.magmadoctor.modelo.profissional.Profissional;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface AgendaDAO {

   public void salvar(Agenda agenda);

   public void atualizar(Agenda agenda);

   public void excluir(Agenda agenda);

   public Agenda porId(Integer id);

   public List<Agenda> listarTodos();

   public List<Agenda> listarPorProfissional(Profissional profissional);

   public List<Agenda> listarPorProfissionalData(Profissional profissional, Date data);

   public List<Agenda> listarPorData(Date data);

   public List<Agenda> listarPorNome(String nome);

   public Integer retornaUltimoCodigo();

}
