package br.com.magmadoctor.modelo.especialidade;

import br.com.magmadoctor.modelo.agenda.Agenda;
import br.com.magmadoctor.modelo.profissional.Profissional;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Aguinaldo
 */
@Entity
public class Especialidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    private String nome;

    @ManyToMany(mappedBy = "especialidades")
    private List<Profissional> profissionais;

    @OneToMany(mappedBy = "especialidade")
    private List<Agenda> agendas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public List<Agenda> getAgendas() {
        return agendas;
    }

    public void setAgendas(List<Agenda> agendas) {
        this.agendas = agendas;
    }

}
