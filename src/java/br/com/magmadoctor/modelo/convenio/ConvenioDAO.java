/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.convenio;

import java.util.List;

/**
 *
 * @author Aguinaldo
 */
public interface ConvenioDAO {

    public void salvar(Convenio convenio);

    public void atualizar(Convenio convenio);

    public void excluir(Convenio convenio);

    public List<Convenio> listarPorNome(String nome);

    public List<Convenio> listarTodos();
    
    public Convenio porNome(String nome);
    
    public Convenio porId(Integer id);
    

}
