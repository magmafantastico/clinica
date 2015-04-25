package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.profissional.Profissional;
import br.com.magmadoctor.modelo.profissional.ProfissionalRN;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "agendaProfissionalConverter")
public class AgendaProfissionalConverter implements Converter {

    private List<Profissional> p = new ArrayList<Profissional>();
    private Profissional profissional;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if ((!value.equals("")) && (value != null)) {
            ProfissionalRN pRN = new ProfissionalRN();
            profissional = pRN.porNome(value);
            return profissional;
        }
        return profissional;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        try {
            profissional = new Profissional();
            profissional = (Profissional) o;
            return profissional.getNome();
        } catch (Exception e) {
            return "erro: " + e;
        }
    }

}
