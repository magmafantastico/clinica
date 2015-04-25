   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.salaEspera;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface SalaEsperaDAO {

   public void salvar(SalaEspera salaEspera);

   public void atualizar(SalaEspera salaEspera);

   public void excluir(SalaEspera salaEspera);

   public SalaEspera porId(Integer id);

   public List<SalaEspera> listarTodos();

}
