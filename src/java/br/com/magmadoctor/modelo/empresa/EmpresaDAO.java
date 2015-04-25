/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.magmadoctor.modelo.empresa;


import java.util.List;

/**
 *
 * @author Aguinaldo
 */
public interface EmpresaDAO {
    
    public void salvar(Empresa empresa);

    public void atualizar(Empresa empresa);

    public void excluir(Empresa empresa); 
              
    public List<Empresa> listarPorNome(String nome);    
    
    public List<Empresa> listarTodos();    
    
}
