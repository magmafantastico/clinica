/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.sala.Sala;
import br.com.magmadoctor.modelo.sala.SalaRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aguinaldo
 */
@ManagedBean
@ViewScoped
public class SalaMB {

    private Sala sala = new Sala();
    private List<Sala> listarTodos;
    private String pagina;

    public SalaMB() {
        this.pagina = "sala";
        sala = new Sala();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String novo() {
        this.sala = new Sala();
        return pagina;
    }

    public String inserir() {
        SalaRN sRN = new SalaRN();
        if (this.sala.getCodigo() != null && this.sala.getCodigo() != 0) {
            sRN.atualizar(getSala());
            FacesMessage msg = new FacesMessage("SALA ATUALIZADA COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            sRN.salvar(getSala());
            novo();
            FacesMessage msg = new FacesMessage("SALA CADASTRADA COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public String excluir() {
        SalaRN cRN = new SalaRN();
        if (this.sala.getCodigo() != null && this.sala.getCodigo() != 0) {
            cRN.excluir(getSala());
            FacesMessage msg = new FacesMessage("SALA EXCLUIDA COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR SALA PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public void setListarTodos(List<Sala> listarTodos) {
        this.listarTodos = listarTodos;
    }

    public List<Sala> getListarTodos() {
        SalaRN cRN = new SalaRN();
        return cRN.listarTodos();
    }

}
