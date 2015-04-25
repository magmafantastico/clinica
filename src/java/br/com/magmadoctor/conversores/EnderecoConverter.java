package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.endereco.Endereco;
import br.com.magmadoctor.modelo.endereco.EnderecoRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "enderecoConverter")
public class EnderecoConverter implements Converter {

    private final List<Endereco> e = new ArrayList<>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        EnderecoRN eRN = new EnderecoRN();
        Endereco endereco = eRN.porNome(string);
        e.add(endereco);
        return e;
    }

    @Override
    public String getAsString(final FacesContext fc, final UIComponent uic, final Object o) {
        if (o instanceof List<?>) {
            final StringBuffer result = new StringBuffer();
            final List<Endereco> list = (List<Endereco>) o;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) instanceof Endereco) {
                    result.append(((Endereco) list.get(i)).getLogradouro()).append(" - ").append(((Endereco) list.get(i)).getNumero());
                } else {
                    throw new IllegalArgumentException("Cannot convert " + o + " object to Endereco in EnderecoConverter.");
                }
            }
            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) instanceof Endereco) {
                    result.append(((Endereco) list.get(list.size() - 1)).getLogradouro());
                    result.append(" - ");
                    result.append(((Endereco) list.get(list.size() - 1)).getNumero());
                } else {
                    throw new IllegalArgumentException("Cannot convert " + o + " object to Endereco in EnderecoConverter.");
                }
            }
            return result.toString();
        } else {
            throw new IllegalArgumentException("Cannot convert " + o + " object to List in EnderecoConverter.");
        }
    }
}
