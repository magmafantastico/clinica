/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.convenio;

import br.com.magmadoctor.modelo.agenda.Agenda;
import br.com.magmadoctor.modelo.contato.Contato;
import br.com.magmadoctor.modelo.email.Email;
import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.paciente.Paciente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Convenio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String razaoSocial;

    @Column(length = 50)
    private String nomeFantasia;

    private String cnpj;

    private String cnes;

    private String regANS;

    private String urlWebService;

    private String codPrestador;

    private Integer diaFaturamento;

    private String qtdDiasRetorno;

    @ManyToMany(mappedBy = "convenios")
    private List<Paciente> pacientes;

    @OneToMany(mappedBy = "convenio")
    private List<Agenda> agendas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "convenio_enderecos",
            joinColumns = @JoinColumn(name = "convenio_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "convenio_contatos",
            joinColumns = @JoinColumn(name = "convenio_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "convenio_emails",
            joinColumns = {
                @JoinColumn(name = "convenio_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "email_id", referencedColumnName = "id")})
    private List<Email> emails;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public String getRegANS() {
        return regANS;
    }

    public void setRegANS(String regANS) {
        this.regANS = regANS;
    }

    public String getUrlWebService() {
        return urlWebService;
    }

    public void setUrlWebService(String urlWebService) {
        this.urlWebService = urlWebService;
    }

    public String getCodPrestador() {
        return codPrestador;
    }

    public void setCodPrestador(String codPrestador) {
        this.codPrestador = codPrestador;
    }

    public Integer getDiaFaturamento() {
        return diaFaturamento;
    }

    public void setDiaFaturamento(Integer diaFaturamento) {
        this.diaFaturamento = diaFaturamento;
    }

    public String getQtdDiasRetorno() {
        return qtdDiasRetorno;
    }

    public void setQtdDiasRetorno(String qtdDiasRetorno) {
        this.qtdDiasRetorno = qtdDiasRetorno;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

}
