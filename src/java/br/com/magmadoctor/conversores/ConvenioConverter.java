package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.convenio.ConvenioRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "convenioConverter")
public class ConvenioConverter implements Converter {

    private List<Convenio> c = new ArrayList<Convenio>();

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ConvenioRN cRN = new ConvenioRN();
        Convenio convenio = cRN.porNome(string);
        c.add(convenio);
        return c;
    }

    @Override
    public String getAsString(final FacesContext fc, final UIComponent uic, final Object o) {
        if (o instanceof List<?>) {
            final StringBuffer result = new StringBuffer();
            final List<Convenio> list = (List<Convenio>) o;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) instanceof Convenio) {
                    result.append(((Convenio) list.get(i)).getNomeFantasia());
                    result.append(", ");
                } else {
                    throw new IllegalArgumentException("Cannot convert " + o + " object to Convenio in ConvenioConverter.");
                }
            }
            if (!list.isEmpty()) {
                if (list.get(list.size() - 1) instanceof Convenio) {
                    result.append(((Convenio) list.get(list.size() - 1)).getNomeFantasia());
                } else {
                    throw new IllegalArgumentException("Cannot convert " + o + " object to Convenio in ConvenioConverter.");
                }
            }
            return result.toString();
        } else {
            throw new IllegalArgumentException("Cannot convert " + o + " object to List in ConvenioConverter.");
        }
    }
}
