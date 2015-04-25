/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.modelo.cid10;

import java.io.Serializable;
import javax.persistence.Id;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author Dirceu Junior
 */
public class Cid implements Serializable {
    
    @Id
    private Integer codigo;
    private String codGeral;
    @NaturalId
    private String descricao;
    private String categoria;
    private String subCategoria;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCodGeral() {
        return codGeral;
    }

    public void setCodGeral(String codGeral) {
        this.codGeral = codGeral;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSubCategoria() {
        return subCategoria;
    }

    public void setSubCategoria(String subCategoria) {
        this.subCategoria = subCategoria;
    }

       
    
}
