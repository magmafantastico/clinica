/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.convenio;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Aguinaldo
 */
public class ConvenioRN {

    private final ConvenioDAO convenioDAO;

    public ConvenioRN() {
        this.convenioDAO = DAOFactory.criarConvenioDAO();
    }

//    public void inserir(Convenio convenio) {
//        if (convenio.getId() < 0 || convenio.getId() == 0) {
//            System.out.println("cadastrando --- " + convenio.getNomeFantasia());
//            this.convenioDAO.salvar(convenio);
//            FacesMessage msg = new FacesMessage("Cadastro efetuado com sucesso!!!");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        } else {
//            System.out.println("alterando --- " + convenio.getNomeFantasia());
//            this.convenioDAO.atualizar(convenio);
//            FacesMessage msg = new FacesMessage("Cadastro Alterado com sucesso!!!");
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//    }

    public void excluir(Convenio convenio) {
        this.convenioDAO.excluir(convenio);
    }

    public void salvar(Convenio convenio) {
        this.convenioDAO.salvar(convenio);
    }

    public void atualizar(Convenio convenio) {
        this.convenioDAO.atualizar(convenio);
    }

    public List<Convenio> listar(String nome) {
        return this.convenioDAO.listarPorNome(nome);
    }

    public List<Convenio> listarTodos() {
        return this.convenioDAO.listarTodos();
    }

    public Convenio porNome(String nome) {
        return this.convenioDAO.porNome(nome);
    }

    public Convenio porId(Integer id) {
        return this.convenioDAO.porId(id);
    }

}
