/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.categoria;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class CategoriaRN {

    private CategoriaDAO categoriaDAO;

    public CategoriaRN() {
        this.categoriaDAO = DAOFactory.criarCategoriaDAO();
    }

    public void salvar(Categoria categoria) {
        this.categoriaDAO.salvar(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.categoriaDAO.atualizar(categoria);
    }

    public void excluir(Categoria categoria) {
        this.categoriaDAO.excluir(categoria);
    }

    public List<Categoria> listarTodos() {
        return this.categoriaDAO.listarTodos();
    }

    public List<Categoria> listarPorNome(String nome) {
        return this.categoriaDAO.listarPorNome(nome);
    }

    public int retornaUltimoCodigo() {
        return this.categoriaDAO.retornaUltimoCodigo();
    }

    public Categoria retornaCategoriaPorCodigo(int codigo) {
        return this.categoriaDAO.retornaCategoriaPorCodigo(codigo);
    }
}
