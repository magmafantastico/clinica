/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.estadoMunicipio;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class EstadoMunicipioRN {
    
    private final EstadoMunicipioDAO estMunDAO;
    
    public EstadoMunicipioRN(){
        this.estMunDAO = DAOFactory.criarEstadoMunicipioDAO();
    }

    public List<Estado> listarEstados(){
        return this.estMunDAO.listarEstados();
    }
    
    public List<Municipio> listarMunicipios(){
        return this.estMunDAO.listarMunicipios();
    }
    
    public List<Municipio> buscarPorUF(Integer codigo){
        return this.estMunDAO.buscarPorUF(codigo);
    }
}
