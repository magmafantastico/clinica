/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.estadoMunicipio;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Estado implements Serializable {

    @Id
    private Integer id;
    @NaturalId
    private String nome;
    private String sigla;
    private Integer ibge;

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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

}
