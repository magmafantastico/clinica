/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.endereco;

import br.com.magmadoctor.util.DAOFactory;
import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public class EnderecoRN {

    private final EnderecoDAO enderecoDAO;

    public EnderecoRN() {
        this.enderecoDAO = DAOFactory.criarEnderecoDAO();
    }

    public void salvar(Endereco endereco) {
        this.enderecoDAO.salvar(endereco);
    }

    public void atualizar(Endereco endereco) {
        this.enderecoDAO.atualizar(endereco);
    }

    public void excluir(Endereco endereco) {
        this.enderecoDAO.excluir(endereco);
    }

    public List<Endereco> listarTodos() {
        return this.enderecoDAO.listarTodos();
    }

    public List<Endereco> listarPorNome(String nome) {
        return this.enderecoDAO.listarPorNome(nome);
    }

    public int buscaUltimoRegistro() {
        return this.enderecoDAO.retornaUltimoCodigo();
    }

    public Endereco porId(int id) {
        return this.enderecoDAO.porId(id);
    }

    public Endereco porNome(String nome) {
        return this.enderecoDAO.porNome(nome);
    }

}
