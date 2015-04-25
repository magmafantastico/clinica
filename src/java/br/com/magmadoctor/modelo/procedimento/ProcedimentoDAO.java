/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.procedimento;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface ProcedimentoDAO {

    public void salvar(Procedimento procedimento);

    public void atualizar(Procedimento procedimento);

    public void excluir(Procedimento procedimento);

    public Procedimento carregar(Integer codigo);

    public List<Procedimento> listarPorNome(String nome);

    public List<Procedimento> listar();
}
