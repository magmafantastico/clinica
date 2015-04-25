package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.especialidade.Especialidade;
import br.com.magmadoctor.modelo.especialidade.EspecialidadeRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "agendaEspecialidadeConverter")
public class AgendaEspecialidadeConverter implements Converter {

    private Especialidade especialidade;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if ((!value.equals("")) && (value != null)) {
            EspecialidadeRN eRN = new EspecialidadeRN();
            especialidade = eRN.porNome(value);
            return especialidade;
        }
        return especialidade;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        try {
            especialidade = new Especialidade();
            especialidade = (Especialidade) o;
            return especialidade.getNome();
        } catch (Exception e) {
            return "erro: " + e;
        }
    }

}
