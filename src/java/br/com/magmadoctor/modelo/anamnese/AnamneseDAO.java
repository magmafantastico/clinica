   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.anamnese;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface AnamneseDAO {

    public void salvar(Anamnese anamnese);

    public void atualizar(Anamnese anamnese);

    public void excluir(Anamnese anamnese);

    public Anamnese porCodigo(Integer codigo);

    public Anamnese porNome(String nome);

    public List<Anamnese> listarTodos();

    public Integer retornaUltimoCodigo();

}
