/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.profissional;

import br.com.magmadoctor.modelo.agenda.Agenda;
import br.com.magmadoctor.modelo.contato.Contato;
import br.com.magmadoctor.modelo.documento.Documento;
import br.com.magmadoctor.modelo.email.Email;
import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.especialidade.Especialidade;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Profissional implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    private String numero;

    private String cpf;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    private String sexo;

    private String estadoCivil;

    @Column(length = 250)
    private String observacoes;

    private String conselho;

    private String cns;

    private String registro;

    private String estadoRegistroCRM;

    private String color;

    @ManyToMany
    @JoinTable(
            name = "profissional_especialidade",
            joinColumns = @JoinColumn(name = "profissional_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidade_id"))
    private List<Especialidade> especialidades;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "profissional_enderecos",
            joinColumns = @JoinColumn(name = "profissional_id"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "profissional_contatos",
            joinColumns = @JoinColumn(name = "profissional_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> contatos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "profissional_emails",
            joinColumns = @JoinColumn(name = "profissional_id"),
            inverseJoinColumns = @JoinColumn(name = "email_id"))
    private List<Email> emails;

    @OneToOne
    private Documento documento;

    @OneToMany(mappedBy = "profissional")
    private List<Agenda> agendas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getConselho() {
        return conselho;
    }

    public void setConselho(String conselho) {
        this.conselho = conselho;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getEstadoRegistroCRM() {
        return estadoRegistroCRM;
    }

    public void setEstadoRegistroCRM(String estadoRegistroCRM) {
        this.estadoRegistroCRM = estadoRegistroCRM;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
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

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
