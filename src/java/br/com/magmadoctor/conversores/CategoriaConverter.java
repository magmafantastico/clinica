package br.com.magmadoctor.conversores;

import br.com.magmadoctor.modelo.categoria.Categoria;
import br.com.magmadoctor.modelo.categoria.CategoriaRN;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null && value.trim().length() > 0) {
            Integer codigo = Integer.valueOf(value);
            try {
                CategoriaRN categoriaRN = new CategoriaRN();
                return categoriaRN.retornaCategoriaPorCodigo(codigo);
            } catch (Exception e) {
                throw new ConverterException("N�o foi poss�vel encontrar a categoria de c�digo " + value + "." + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Categoria categoria = (Categoria) value;
            return String.valueOf(categoria.getCodigo());
        }
        return "";
    }
}
