/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.endereco;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface EnderecoDAO {

    public void salvar(Endereco endereco);

    public void atualizar(Endereco endereco);

    public void excluir(Endereco endereco);

    public Endereco porId(Integer id);

    public Endereco porNome(String nome);

    public List<Endereco> listarTodos();

    public List<Endereco> listarPorNome(String nome);

    public Integer retornaUltimoCodigo();

}
