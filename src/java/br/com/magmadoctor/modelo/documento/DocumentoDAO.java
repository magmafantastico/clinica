/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.documento;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface DocumentoDAO {

    public void salvar(Documento documento);

    public void atualizar(Documento documento);

    public void excluir(Documento documento);

    public Documento porId(Integer id);

}
