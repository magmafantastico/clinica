package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.especialidade.Especialidade;
import br.com.magmadoctor.modelo.especialidade.EspecialidadeRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "especialidadeConverter")
public class EspecialidadeConverter implements Converter {

    private List<Especialidade> e = new ArrayList<Especialidade>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        EspecialidadeRN eRN = new EspecialidadeRN();
        Especialidade especialidade = eRN.porNome(string);
        e.add(especialidade);
        return e;
    }

    @Override
    public String getAsString(final FacesContext fc, final UIComponent uic, final Object o) {
        if (o instanceof List<?>) {
            final StringBuffer result = new StringBuffer();
            final List<Especialidade> list = (List<Especialidade>) o;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) instanceof Especialidade) {
                    result.append(((Especialidade) list.get(i)).getNome());
                    result.append(", ");
                } else {
                    throw new IllegalArgumentException("Cannot convert " + o + " object to Especialidade in EspecialidadeConverter.");
                }
            }
            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) instanceof Especialidade) {
                    result.append(((Especialidade) list.get(list.size() - 1)).getNome());
                } else {
                    throw new IllegalArgumentException("Cannot convert " + o + " object to Especialidade in EspecialidadeConverter.");
                }
            }
            return result.toString();
        } else {
            throw new IllegalArgumentException("Cannot convert " + o + " object to List in EspecialidadeConverter.");
        }
    }
}
