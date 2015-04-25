/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.magmadoctor.modelo.profissional;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Aguinaldo
 */
public interface ProfissionalDAO extends Serializable{
    
    public void salvar(Profissional profissional);

    public void atualizar(Profissional profissional);

    public void excluir(Profissional profissional);
    
    public Profissional porId(Integer id);
    
    public Profissional porNome (String nome);

    public List<Profissional> listarTodos();

    public List<Profissional> listarPorNome(String nome);
    
    public List<Profissional> listarPorEspecilizacao(String especializacao);
    
    public Integer retornaUltimoCodigo();
}