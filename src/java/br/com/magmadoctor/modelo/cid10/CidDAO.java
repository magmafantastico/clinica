/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.cid10;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface CidDAO {

    public void salvar(Cid cid);

    public void atualizar(Cid cid);

    public void excluir(Cid cid);

    public List<Cid> listarTodos();

    public List<Cid> listarPorNome(String nome);

}
