package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.paciente.Paciente;
import br.com.magmadoctor.modelo.paciente.PacienteRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "pacienteConverter")
public class PacienteConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        PacienteRN pRN = new PacienteRN();
        Paciente paciente = pRN.porNome(string);
        return paciente;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        Paciente paciente = new Paciente();
        paciente = (Paciente) o;
        return paciente.getNome();
    }

}
