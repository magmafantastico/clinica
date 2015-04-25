/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.estadoMunicipio;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface EstadoMunicipioDAO {

    public List<Municipio> listarMunicipios();

    public List<Estado> listarEstados();

    public List<Municipio> buscarPorUF(Integer id);

}
