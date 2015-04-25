/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.conversores;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Dirceu Junior
 */
public class ControlaJTextField extends PlainDocument {

    private int iMaxLength;
    private int controleQtde;
    private int controleTipo;

    public ControlaJTextField(int tamMax, int tipo) {
        super();
        if (tamMax <= 0) {
            throw new IllegalArgumentException("Especificar Tamanho do Campo");
        }
        controleQtde = tamMax;
        controleTipo = tipo;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException {

        if (str == null) {
            return;
        }

        if (controleQtde <= 0) { // aceitara qualquer no. de caracteres  
            super.insertString(offset, str, attr);
            return;
        }

        int ilen = (getLength() + str.length());
        if (ilen <= controleQtde) {// se o comprimento final for menor...  
            if (controleTipo == 1) {
                super.insertString(offset, str.toUpperCase(), attr);
            } else if (controleTipo == 0) {
                super.insertString(offset, str.replaceAll("[^0-9]", ""), attr);
            }
        } else {
            if (getLength() == controleQtde) {
                return; // nada a fazer  
            }
            String newStr = str.substring(0, (controleQtde - getLength()));
            super.insertString(offset, newStr, attr);
        }
    }

}
