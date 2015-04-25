/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.mb;

import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.endereco.EnderecoRN;
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
public class EnderecoMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private Endereco selecionado;
    private Endereco endereco = new Endereco();
    private List<Endereco> listarTodos;
    private List<Endereco> listarPorNome;
    private List<Endereco> enderecos = new ArrayList<Endereco>();
    private String pagina;

    public EnderecoMB() {
        this.pagina = "enderecos";
        endereco = new Endereco();
    }

    public String inserir() {
        EnderecoRN eRN = new EnderecoRN();
        if (this.endereco.getId() != null && this.endereco.getId() != 0) {
            eRN.atualizar(getEndereco());
            FacesMessage msg = new FacesMessage("PACIENTE ATUALIZADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            eRN.salvar(getEndereco());
            FacesMessage msg = new FacesMessage("PACIENTE CADASTRADO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public String excluir() {
        EnderecoRN eRN = new EnderecoRN();
        if (this.endereco.getId() != null && this.endereco.getId() != 0) {
            eRN.excluir(getEndereco());
            FacesMessage msg = new FacesMessage("PACIENTE EXCLUIDO COM SUCESSO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            FacesMessage msg = new FacesMessage("FAVOR SELECIONAR PACIENTE PARA EXCLUSÃO!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        return pagina;
    }

    public String editar() {
        EnderecoRN eRN = new EnderecoRN();
        endereco = eRN.porId(endereco.getId());
        return pagina;
    }

    public String novo() {
        this.endereco = new Endereco();
        return pagina;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getListarTodos() {
        EnderecoRN eRN = new EnderecoRN();
        listarTodos = eRN.listarTodos();
        return listarTodos;
    }

    public void setListarTodos(List<Endereco> listar) {
        this.listarTodos = listar;
    }

    public List<Endereco> getListarPorNome() {
        EnderecoRN eRN = new EnderecoRN();
        listarPorNome = eRN.listarPorNome(endereco.getLogradouro());
        return listarPorNome;
    }

    public void setListarPorNome(List<Endereco> listarPorNome) {
        this.listarPorNome = listarPorNome;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public List<Endereco> completaNome(String query) {
        EnderecoRN eRN = new EnderecoRN();
        this.enderecos = eRN.listarTodos();
        List<Endereco> sugestoes = new ArrayList<Endereco>();
        for (Endereco j : this.enderecos) {
            if (j.getLogradouro().startsWith(query)) {
                sugestoes.add(j);
            }
        }
        return sugestoes;
    }

}
