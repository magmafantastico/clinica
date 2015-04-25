package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.convenio.Convenio;
import br.com.magmadoctor.modelo.convenio.ConvenioRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "agendaConvenioConverter")
public class AgendaConvenioConverter implements Converter {

    private Convenio convenio;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if ((!value.equals("")) && (value != null)) {
            ConvenioRN eRN = new ConvenioRN();
            convenio = eRN.porNome(value);
            return convenio;
        }
        return convenio;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        try {
            convenio = new Convenio();
            convenio = (Convenio) o;
            return convenio.getNomeFantasia();
        } catch (Exception e) {
            return "erro: " + e;
        }
    }

}
