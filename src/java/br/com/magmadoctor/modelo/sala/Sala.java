package br.com.magmadoctor.modelo.sala;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Sala implements Serializable {

    private static final long serialVersionUID = 6537192113746253731L;

    @Id
    @GeneratedValue
    @Column(name = "cod_sala")
    private Integer codigo;

    @Column(name = "descricao")
    private String descricao;

    private String tipo;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
