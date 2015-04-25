/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.especialidade;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class EspecialidadeRN {

    private final EspecialidadeDAO especialidadeDAO;

    public EspecialidadeRN() {
        this.especialidadeDAO = DAOFactory.criarEspecialidadeDAO();
    }

    public void salvar(Especialidade especialidade) {
        this.especialidadeDAO.salvar(especialidade);
    }

    public void atualizar(Especialidade especialidade) {
        this.especialidadeDAO.atualizar(especialidade);
    }

    public void excluir(Especialidade especialidade) {
        this.especialidadeDAO.excluir(especialidade);
    }

    public List<Especialidade> listarTodos() {
        return this.especialidadeDAO.listarTodos();
    }

    public List<Especialidade> listarPorNome(String nome) {
        return this.especialidadeDAO.listarPorNome(nome);
    }

    public Especialidade porId(Integer id) {
        return this.especialidadeDAO.porId(id);
    }

    public Especialidade porNome(String nome) {
        return this.especialidadeDAO.porNome(nome);
    }

}
