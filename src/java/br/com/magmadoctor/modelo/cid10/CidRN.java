/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.cid10;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Dirceu Junior
 */
public class CidRN {

    private CidDAO cidDAO;

    public CidRN() {
        this.cidDAO = DAOFactory.criarCidDAO();
    }

    public void salvar(Cid cid) {
        if (cid.getCodigo() == null || cid.getCodigo() == 0) {
            this.cidDAO.salvar(cid);
            FacesMessage msg = new FacesMessage("Cadastro efetuado com sucesso!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            this.cidDAO.atualizar(cid);
            FacesMessage msg = new FacesMessage("Cadastro Alterado com sucesso!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void excluir(Cid cid) {
        this.cidDAO.excluir(cid);
    }

    public List<Cid> listarTodos() {
        return this.cidDAO.listarTodos();
    }

    public List<Cid> listarPorNome(String nome) {
        return this.cidDAO.listarPorNome(nome);
    }

}
