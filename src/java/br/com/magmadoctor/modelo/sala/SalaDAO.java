/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.magmadoctor.modelo.sala;

import java.util.List;

/**
 *
 * @author Aguinaldo
 */
public interface SalaDAO {
    
    public void salvar(Sala sala);

    public void atualizar(Sala sala);

    public void excluir(Sala sala);

    public List<Sala> listarTodos();
    
}
