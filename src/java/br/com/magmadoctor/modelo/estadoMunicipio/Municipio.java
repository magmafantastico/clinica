/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.estadoMunicipio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Dirceu Junior
 */
@Entity
public class Municipio implements Serializable {

    @Id
    private Integer id;
    private String nome;
    private Integer ibge;
    private String estado_id;

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

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(String estado_id) {
        this.estado_id = estado_id;
    }

}
