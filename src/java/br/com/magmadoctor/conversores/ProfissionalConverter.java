package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.profissional.Profissional;
import br.com.magmadoctor.modelo.profissional.ProfissionalRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "profissionalConverter")
public class ProfissionalConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        ProfissionalRN pRN = new ProfissionalRN();
        Profissional profissional = pRN.porNome(string);
        return profissional;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Profissional profissional = new Profissional();
        profissional = (Profissional) o;
        return profissional.getNome();
    }

}
