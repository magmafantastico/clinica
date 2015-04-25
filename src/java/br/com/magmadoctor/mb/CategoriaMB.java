/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.categoria.Categoria;
import br.com.magmadoctor.modelo.categoria.CategoriaRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class CategoriaMB {

    private Categoria categoria;
    private List<Categoria> listaCategorias;

    public CategoriaMB() {
        categoria = new Categoria();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListaCategorias() {
        CategoriaRN categoriaRN = new CategoriaRN();
        listaCategorias = categoriaRN.listarTodos();
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    public String inserirCategoria() {
        try {
            CategoriaRN cat = new CategoriaRN();
            cat.salvar(getCategoria());

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Erro!!! " + e.toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return "categorias";
    }

}
