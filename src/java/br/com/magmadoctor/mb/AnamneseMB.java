/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.endereco.EnderecoRN;
import br.com.magmadoctor.modelo.anamnese.Anamnese;
import br.com.magmadoctor.modelo.anamnese.AnamneseRN;
import java.io.Serializable;
import java.util.ArrayList;
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
public class AnamneseMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Anamnese anamnese = new Anamnese();

    private List<Anamnese> listarTodos;

    private List<Anamnese> anamneses = new ArrayList<Anamnese>();

    private String pagina;

    public AnamneseMB() {
        this.pagina = "anamnese";
    }

    public String inserir() {
        AnamneseRN qRN = new AnamneseRN();
        EnderecoRN eRN = new EnderecoRN();
        if (this.anamnese.getCodigo() != null && this.anamnese.getCodigo() != 0) {
            qRN.atualizar(getAnamnese());
            FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            qRN.salvar(getAnamnese());
            FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public String excluir() {
        AnamneseRN qRN = new AnamneseRN();
        if (this.anamnese.getCodigo() != null && this.anamnese.getCodigo() != 0) {
            qRN.excluir(getAnamnese());
            FacesMessage msg = new FacesMessage("EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public String editar() {
        AnamneseRN qRN = new AnamneseRN();
        anamnese = qRN.porCodigo(anamnese.getCodigo());
        return pagina;
    }

    public String novo() {
        this.anamnese = new Anamnese();
        return pagina;
    }

    public Anamnese getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(Anamnese anamnese) {
        this.anamnese = anamnese;
    }

    public List<Anamnese> getListarTodos() {
        AnamneseRN qRN = new AnamneseRN();
        listarTodos = qRN.listarTodos();
        return listarTodos;
    }

    public void setListarTodos(List<Anamnese> listar) {
        this.listarTodos = listar;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

}
