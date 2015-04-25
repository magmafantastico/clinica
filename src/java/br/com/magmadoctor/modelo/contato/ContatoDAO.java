/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.contato;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface ContatoDAO {

    public void salvar(Contato contato);

    public void atualizar(Contato contato);

    public void excluir(Contato contato);

    public Contato porId(Integer id);

    public List<Contato> listarTodos();

}
