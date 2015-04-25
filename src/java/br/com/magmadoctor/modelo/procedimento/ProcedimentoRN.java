/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.procedimento;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dirceu Junior
 */
public class ProcedimentoRN {

    private ProcedimentoDAO procedimentoDAO;

    public ProcedimentoRN() {
        this.procedimentoDAO = DAOFactory.criarProcedimentoDAO();
    }

    public Procedimento carregar(Integer codigo) {
        return this.procedimentoDAO.carregar(codigo);
    }

    public void inserir(Procedimento procedimento) {

        if (procedimento.getId() == null || procedimento.getId() == 0) {
            System.out.println("cadastrando --- " + procedimento.getNome());
            this.procedimentoDAO.salvar(procedimento);
            FacesMessage msg = new FacesMessage("Cadastro efetuado com sucesso!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            System.out.println("alterando --- " + procedimento.getNome());
            this.procedimentoDAO.atualizar(procedimento);
            FacesMessage msg = new FacesMessage("Cadastro Alterado com sucesso!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void excluir(Procedimento procedimento) {
        this.procedimentoDAO.excluir(procedimento);
    }

    public List<Procedimento> listar() {
        return this.procedimentoDAO.listar();
    }

    public List<Procedimento> listarPorNome(String nome) {
        return this.procedimentoDAO.listarPorNome(nome);
    }
}
