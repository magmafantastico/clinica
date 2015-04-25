package br.com.magmadoctor.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "cnpjConverter")
public class CNPJConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        String cnpj = value;
        if (value != null && !value.equals("")) {
            cnpj = value.replaceAll("\\.", "").replaceAll("\\/", "").replaceAll("\\-", "");
        }
        return cnpj;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        String cnpj = String.valueOf(value);
        if (cnpj != null && cnpj.length() == 14) {
            cnpj = cnpj.substring(0, 2) + "."
                    + cnpj.substring(2, 5) + "."
                    + cnpj.substring(5, 8) + "/"
                    + cnpj.substring(8, 12) + "-"
                    + cnpj.substring(12, 14);
        }
        return cnpj;
    }
}
