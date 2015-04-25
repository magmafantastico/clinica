/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.anamnese;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class AnamneseRN {

    private final AnamneseDAO anamneseDAO;

    public AnamneseRN() {
        this.anamneseDAO = DAOFactory.criarAnamneseDAO();
    }

    public void salvar(Anamnese anamnese) {
        this.anamneseDAO.salvar(anamnese);
    }

    public void atualizar(Anamnese anamnese) {
        this.anamneseDAO.atualizar(anamnese);
    }

    public void excluir(Anamnese anamnese) {
        this.anamneseDAO.excluir(anamnese);
    }

    public List<Anamnese> listarTodos() {
        return this.anamneseDAO.listarTodos();
    }

    public int buscaUltimoRegistro() {
        return this.anamneseDAO.retornaUltimoCodigo();
    }

    public Anamnese porCodigo(int codigo) {
        return this.anamneseDAO.porCodigo(codigo);
    }
    
    public Anamnese porNome(String nome){
        return this.anamneseDAO.porNome(nome);
    }
}
