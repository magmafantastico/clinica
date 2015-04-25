package br.com.magmadoctor.conversores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "dataConverter")
public class DataConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
	    throws ConverterException {
	Date data = null;
	try {
	    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    data = new java.sql.Date(format.parse(value).getTime());
	} catch (ParseException e) {
	    System.out.println("Erro: " + e.toString());
	}
	return data;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
	SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
	String data = formataData.format(value);
	return data;
    }

}
