/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.profissional;

import br.com.magmadoctor.util.DAOFactory;

import java.util.List;

/**
 *
 * @author Aguinaldo
 */
public class ProfissionalRN {

    private final ProfissionalDAO profissionalDAO;

    public ProfissionalRN() {
        this.profissionalDAO = DAOFactory.criarProfissionalDAO();
    }

    public void excluir(Profissional profissional) {
        this.profissionalDAO.excluir(profissional);
    }

    public void salvar(Profissional profissional) {
        this.profissionalDAO.salvar(profissional);
    }

    public void atualizar(Profissional profissional) {
        this.profissionalDAO.atualizar(profissional);
    }

    public List<Profissional> listarPorNome(String nome) {
        return this.profissionalDAO.listarPorNome(nome);
    }

    public List<Profissional> listarPorEspecializacao(String especializacao) {
        return this.profissionalDAO.listarPorEspecilizacao(especializacao);
    }

    public Profissional porId(Integer id) {
        return this.profissionalDAO.porId(id);
    }

    public Profissional porNome(String nome) {
        return this.profissionalDAO.porNome(nome);
    }

    public List<Profissional> listarTodos() {
        return this.profissionalDAO.listarTodos();
    }

    public int buscaUltimoRegistro() {
        return this.profissionalDAO.retornaUltimoCodigo();
    }

}
