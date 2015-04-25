   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.especialidade;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface EspecialidadeDAO {

    public void salvar(Especialidade cliente);

    public void atualizar(Especialidade cliente);

    public void excluir(Especialidade cliente);
    
    public List<Especialidade> listarTodos();

    public List<Especialidade> listarPorNome(String nome);

    public Especialidade porId(Integer codigo);
    
    public Especialidade porNome(String nome);
    
}
