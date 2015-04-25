/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.email;


import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface EmailDAO {

    public void salvar(Email email);

    public void atualizar(Email email);

    public void excluir(Email email);

    public Email porId(Integer id);

    public Email porNome(String nome);

    public List<Email> listarTodos();

    public List<Email> listarPorNome(String nome);


}
