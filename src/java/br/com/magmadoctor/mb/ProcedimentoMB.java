/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.procedimento.Procedimento;
import br.com.magmadoctor.modelo.procedimento.ProcedimentoRN;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Adriano Meira
 */
@ManagedBean
@RequestScoped
public class ProcedimentoMB {

    private static final long serialVersionUID = 1L;
    private Procedimento procedimento = new Procedimento();
    private List<Procedimento> listaTodos;
    private List<Procedimento> listaPorNome;
    private String pagina;

    public ProcedimentoMB() {
        pagina = "procedimento";
    }

    public String inserir() {
        try {
            ProcedimentoRN proc = new ProcedimentoRN();
            proc.inserir(getProcedimento());
            return getPagina();
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Erro = " + e.toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return getPagina();
        }
    }

    public String excluir() {
        ProcedimentoRN proc = new ProcedimentoRN();
        proc.excluir(getProcedimento());
        return getPagina();
    }
    
    public String novo(){
        procedimento = new Procedimento();
        return getPagina();
    }

    public void editar() {
        listaPorNome = null;
    }

    public List<Procedimento> getListaTodos() {
        if (this.listaTodos == null) {
            ProcedimentoRN proc = new ProcedimentoRN();
            this.listaTodos = proc.listar();
        }
        return this.listaTodos;
    }

    public List<Procedimento> getListaPorNome() {
        if (this.listaPorNome == null) {
            ProcedimentoRN proc = new ProcedimentoRN();
            this.listaPorNome = proc.listarPorNome(procedimento.getNome());
        }
        return listaPorNome;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public void novoCadastro() {
        procedimento = new Procedimento();
        listaTodos = null;
        listaPorNome = null;
    }

    public void setListaPorNome(List<Procedimento> listaPorNome) {
        this.listaPorNome = listaPorNome;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }
}
