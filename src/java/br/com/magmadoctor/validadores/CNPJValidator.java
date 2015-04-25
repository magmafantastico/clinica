/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.validadores;

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
@FacesValidator(value = "cnpjValidator")
public class CNPJValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (!String.valueOf(value).equals("")) {
            if (!validaCNPJ(String.valueOf(value))) {
                FacesMessage message = new FacesMessage();
                message.setSeverity(FacesMessage.SEVERITY_ERROR);
                message.setSummary("CNPJ Inválido");
                throw new ValidatorException(message);
            }
        }
    }

    public boolean validaCNPJ(String cnpj) {
        if (cnpj == null || cnpj.length() != 14 || isCNPJPadrao(cnpj)) {
            return false;
        }
        try {
            Long.parseLong(cnpj);
        } catch (NumberFormatException e) {
            return false;
        }
        if (!validarCNPJ((cnpj))) {
            return false;
        }
        return true;
    }

    public boolean isCNPJPadrao(String cnpj) {
        if (cnpj.equals("11111111111111") || cnpj.equals("22222222222222")
                || cnpj.equals("33333333333333")
                || cnpj.equals("44444444444444")
                || cnpj.equals("55555555555555")
                || cnpj.equals("66666666666666")
                || cnpj.equals("77777777777777")
                || cnpj.equals("88888888888888")
                || cnpj.equals("99999999999999")) {
            return true;
        }
        return false;
    }

    public boolean validarCNPJ(String strCNPJ) {
        int iSoma = 0, iDigito;
        char[] chCaracteresCNPJ;
        String strCNPJ_Calculado;

        if (!strCNPJ.substring(0, 1).equals("")) {
            try {
                strCNPJ = strCNPJ.replace('.', ' ');
                strCNPJ = strCNPJ.replace('/', ' ');
                strCNPJ = strCNPJ.replace('-', ' ');
                strCNPJ = strCNPJ.replaceAll(" ", "");
                strCNPJ_Calculado = strCNPJ.substring(0, 12);
                if (strCNPJ.length() != 14) {
                    return false;
                }
                chCaracteresCNPJ = strCNPJ.toCharArray();
                for (int i = 0; i < 4; i++) {
                    if ((chCaracteresCNPJ[i] - 48 >= 0) && (chCaracteresCNPJ[i] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i] - 48) * (6 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if ((chCaracteresCNPJ[i + 4] - 48 >= 0) && (chCaracteresCNPJ[i + 4] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i + 4] - 48) * (10 - (i + 1));
                    }
                }
                iDigito = 11 - (iSoma % 11);
                strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
                /* Segunda parte */
                iSoma = 0;
                for (int i = 0; i < 5; i++) {
                    if ((chCaracteresCNPJ[i] - 48 >= 0) && (chCaracteresCNPJ[i] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i] - 48) * (7 - (i + 1));
                    }
                }
                for (int i = 0; i < 8; i++) {
                    if ((chCaracteresCNPJ[i + 5] - 48 >= 0) && (chCaracteresCNPJ[i + 5] - 48 <= 9)) {
                        iSoma += (chCaracteresCNPJ[i + 5] - 48) * (10 - (i + 1));
                    }
                }
                iDigito = 11 - (iSoma % 11);
                strCNPJ_Calculado += ((iDigito == 10) || (iDigito == 11)) ? "0" : Integer.toString(iDigito);
                return strCNPJ.equals(strCNPJ_Calculado);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

}
