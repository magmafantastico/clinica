/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.paciente;

import br.com.magmadoctor.modelo.agenda.Agenda;
import br.com.magmadoctor.modelo.contato.Contato;
import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.documento.Documento;
import br.com.magmadoctor.modelo.email.Email;
import br.com.magmadoctor.modelo.endereco.Endereco;
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
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 *
 * @author Dirceu Junior
 */
@Entity
@SQLDelete(sql = "update Paciente set ativo = 0 where id = ?")
@Where(clause = "ativo = 1")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    private String cpf;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataCadastro;

    private String sexo;

    private String estadoCivil;

    private String etnia;

    private String profissao;

    private String prontuario;

    private String matricula;

    private String religiao;

    private String indicacao;

    private String nacionalidade;

    private String naturalidade;

    @Column(length = 250)
    private String observacoes;

    private Integer ativo;
    //////////////////////////////////////// MAPEAMENTO COM CONVENIOS
    @ManyToMany
    @JoinTable(
	    name = "paciente_convenios",
	    joinColumns = @JoinColumn(name = "paciente_id"),
	    inverseJoinColumns = @JoinColumn(name = "convenio_id"))
    private List<Convenio> convenios;

    //////////////////////////////////////// MAPEAMENTO COM ENDEREÇOS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
	    name = "paciente_enderecos",
	    joinColumns = @JoinColumn(name = "paciente_id"),
	    inverseJoinColumns = @JoinColumn(name = "endereco_id"))
    private List<Endereco> enderecos;

    //////////////////////////////////////// MAPEAMENTO COM CONTATOS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
	    name = "paciente_contatos",
	    joinColumns = @JoinColumn(name = "paciente_id"),
	    inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> contatos;

    //////////////////////////////////////// MAPEAMENTO COM EMAILS
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "paciente_emails",
	    joinColumns = @JoinColumn(name = "paciente_id"),
	    inverseJoinColumns = @JoinColumn(name = "email_id"))
    private List<Email> emails;

    //////////////////////////////////////// MAPEAMENTO COM DOCUMENTOS
    @OneToOne
    private Documento documento;

    //////////////////////////////////////// MAPEAMENTO COM AGENDA
    @OneToMany(mappedBy = "paciente")
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

    public String getEtnia() {
	return etnia;
    }

    public void setEtnia(String etnia) {
	this.etnia = etnia;
    }

    public String getProfissao() {
	return profissao;
    }

    public void setProfissao(String profissao) {
	this.profissao = profissao;
    }

    public String getProntuario() {
	return prontuario;
    }

    public void setProntuario(String prontuario) {
	this.prontuario = prontuario;
    }

    public String getMatricula() {
	return matricula;
    }

    public void setMatricula(String matricula) {
	this.matricula = matricula;
    }

    public String getReligiao() {
	return religiao;
    }

    public void setReligiao(String religiao) {
	this.religiao = religiao;
    }

    public String getIndicacao() {
	return indicacao;
    }

    public void setIndicacao(String indicacao) {
	this.indicacao = indicacao;
    }

    public String getNacionalidade() {
	return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
	this.nacionalidade = nacionalidade;
    }

    public String getNaturalidade() {
	return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
	this.naturalidade = naturalidade;
    }

    public String getObservacoes() {
	return observacoes;
    }

    public void setObservacoes(String observacoes) {
	this.observacoes = observacoes;
    }

    public List<Convenio> getConvenios() {
	return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
	this.convenios = convenios;
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

    public Documento getDocumento() {
	return documento;
    }

    public void setDocumento(Documento documento) {
	this.documento = documento;
    }

    public List<Agenda> getAgendas() {
	return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
	this.agendas = agendas;
    }

    public Integer getAtivo() {
	return ativo;
    }

    public void setAtivo(Integer ativo) {
	this.ativo = ativo;
    }
}
