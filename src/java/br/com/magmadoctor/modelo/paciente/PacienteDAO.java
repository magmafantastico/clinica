   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.paciente;

import java.util.List;

/**
 *
 * @author Dirceu Junior
 */
public interface PacienteDAO {

    public void salvar(Paciente cliente);

    public void atualizar(Paciente cliente);

    public void excluir(Paciente cliente);
    
    public Paciente porId(Integer id);
    
    public Paciente porNome (String nome);

    public List<Paciente> listarTodos();

    public List<Paciente> listarPorNome(String nome);
    
    public Integer retornaUltimoId();
    
    public Paciente porCPF(String cpf);
    
    public List<Paciente> porNomeSimples(String nome);
    
}
