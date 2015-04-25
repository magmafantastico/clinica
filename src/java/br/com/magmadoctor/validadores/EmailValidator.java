/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Dirceu Junior
 */
@FacesValidator(value = "emailValidator")
public class EmailValidator implements Validator {

    public void validate(FacesContext facesContext, UIComponent uIComponent, Object object) throws ValidatorException {

        String enteredEmail = (String) object;
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(enteredEmail);

        boolean matchFound = m.matches();

        if (!matchFound) {
            FacesMessage message = new FacesMessage();
            message.setDetail("E-mail incorreto!");
            message.setSummary("E-mail incorreto!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
