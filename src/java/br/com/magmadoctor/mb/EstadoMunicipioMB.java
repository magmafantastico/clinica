/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;
import br.com.magmadoctor.modelo.estadoMunicipio.Estado;
import br.com.magmadoctor.modelo.estadoMunicipio.EstadoMunicipioRN;
import br.com.magmadoctor.modelo.estadoMunicipio.Municipio;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class EstadoMunicipioMB {

    private Municipio municipio;
    private Estado estado;
    private List<Municipio> listaMunicipios;
    private List<Estado> listaEstados;
    private boolean controle = false;

    public EstadoMunicipioMB() {
        municipio = new Municipio();
        estado = new Estado();
    }

    public Municipio getCidade() {
        return municipio;
    }

    public void setCidade(Municipio municipio) {
        this.municipio = municipio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Municipio> getListaMunicipios() {
        return listaMunicipios;
    }

    public void setListaCidades(List<Municipio> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

    public List<Estado> getListaEstados() {
        EstadoMunicipioRN estMunRN = new EstadoMunicipioRN();
        listaEstados = estMunRN.listarEstados();
        return listaEstados;
    }

    public void setListaEstados(List<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }

    public void carregaCidades(ValueChangeEvent event) {
        int valor = Integer.parseInt(event.getNewValue().toString());
        if (valor != 0) {
            controle = true;
            listaMunicipios = null;
            EstadoMunicipioRN estMunRN = new EstadoMunicipioRN();
            listaMunicipios = estMunRN.buscarPorUF(Integer.parseInt(event.getNewValue().toString()));
        }
    }

}
