/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.categoria;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface CategoriaDAO {

    public void salvar(Categoria categoria);

    public void atualizar(Categoria categoria);

    public void excluir(Categoria categoria);

    public List<Categoria> listarTodos();

    public List<Categoria> listarPorNome(String nome);

    public int retornaUltimoCodigo();

    public Categoria retornaCategoriaPorCodigo(int codigo);

}
