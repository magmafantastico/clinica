/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.especialidade.EspecialidadeRN;
import br.com.magmadoctor.modelo.especialidade.Especialidade;
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
public class EspecialidadeMB {

    private Especialidade especialidade = new Especialidade();
    private List<Especialidade> listaTodos;
    private List<Especialidade> listaPorNome;
    private List<Especialidade> especialidades;
    private String pagina;

    public EspecialidadeMB() {
        this.pagina = "especialidade";
    }

    public String inserir() {
        EspecialidadeRN eRN = new EspecialidadeRN();
        if (this.especialidade.getId() != null && this.especialidade.getId() != 0) {
            eRN.atualizar(getEspecialidade());
            FacesMessage msg = new FacesMessage("ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            eRN.salvar(getEspecialidade());
            FacesMessage msg = new FacesMessage("CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
        return getPagina();
    }

    public String excluir() {
        EspecialidadeRN eRN = new EspecialidadeRN();
        if (this.especialidade.getId() != null && this.especialidade.getId() != 0) {
            eRN.excluir(getEspecialidade());
            FacesMessage msg = new FacesMessage("EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        novo();
        return getPagina();
    }

    public String novo() {
        especialidade = new Especialidade();
        return getPagina();
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Especialidade> getListaTodos() {
        EspecialidadeRN eRN = new EspecialidadeRN();
        listaTodos = eRN.listarTodos();
        return listaTodos;
    }

    public void setListaTodos(List<Especialidade> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public List<Especialidade> getListaPorNome() {
        EspecialidadeRN eRN = new EspecialidadeRN();
        listaPorNome = eRN.listarPorNome(especialidade.getNome());
        return listaPorNome;
    }

    public void setListaPorNome(List<Especialidade> listaPorNome) {
        this.listaPorNome = listaPorNome;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

}
