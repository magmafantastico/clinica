/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.empresa;
import br.com.magmadoctor.util.DAOFactory;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Aguinaldo
 */
public class EmpresaRN {

    private final EmpresaDAO empresaDAO;
    

    public EmpresaRN() {
        this.empresaDAO = DAOFactory.criarEmpresaDAO();
    }

    public void inserir(Empresa empresa) {
        if (empresa.getCodigo()< 0 || empresa.getCodigo()== 0) {
            System.out.println("cadastrando --- " + empresa.getNomeFantasia());
            this.empresaDAO.salvar(empresa);
            FacesMessage msg = new FacesMessage("Cadastro efetuado com sucesso!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } else {
            System.out.println("alterando --- " + empresa.getNomeFantasia());
            this.empresaDAO.atualizar(empresa);
            FacesMessage msg = new FacesMessage("Cadastro Alterado com sucesso!!!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void excluir(Empresa empresa) {
        this.empresaDAO.excluir(empresa);
    }

    public void salvar(Empresa empresa) {
        this.empresaDAO.salvar(empresa);
    }

    public void atualizar(Empresa empresa) {
        this.empresaDAO.atualizar(empresa);
    }

    public List<Empresa> listar(String nome) {
        return this.empresaDAO.listarPorNome(nome);
    }

    public List<Empresa> listarTodos() {
        return this.empresaDAO.listarTodos();
    }

}
