/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.documento;

import br.com.magmadoctor.modelo.paciente.Paciente;
import br.com.magmadoctor.modelo.profissional.Profissional;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    ////////////////////////////////////////////////////////// rg - registro geral
    private String rg;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataEmissao;

    private String orgaoEmissor;

    private Integer ufEmissor;

    ///////////////////////////////////////////////////////// cnh - carteira nacional de habilitação
    private String cnh;

    ///////////////////////////////////////////////////////// titulo eleitoral
    private String tituloEleitor;

    private String zona;

    private String urna;

    @OneToOne(mappedBy = "documento")
    private Paciente paciente;

    @OneToOne(mappedBy = "documento")
    private Profissional profissional;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        this.orgaoEmissor = orgaoEmissor;
    }

    public Integer getUfEmissor() {
        return ufEmissor;
    }

    public void setUfEmissor(Integer ufEmissor) {
        this.ufEmissor = ufEmissor;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTituloEleitor() {
        return tituloEleitor;
    }

    public void setTituloEleitor(String tituloEleitor) {
        this.tituloEleitor = tituloEleitor;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getUrna() {
        return urna;
    }

    public void setUrna(String urna) {
        this.urna = urna;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }
    

}
