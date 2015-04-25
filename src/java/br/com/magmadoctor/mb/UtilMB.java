package br.com.magmadoctor.mb;

import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Dirceu Junior
 */
@ManagedBean
@ViewScoped
public class UtilMB {

   private String maskNroContato;
   private String maskAreaContato;
   private String tipo;

   public UtilMB() {
      maskNroContato = "9999-9999";
      maskAreaContato = "99";
   }

   public void maskContato(String codArea) {
      if (tipo != null) {
         if (tipo.equals("CELULAR")) {
            if (codArea.equals("18")) {
               maskNroContato = "9-9999-9999";
            } else {
               maskNroContato = "9999-9999";
            }
         } else {
            maskNroContato = "9999-9999";
         }
      }
   }

   public void selecionaTipo(ValueChangeEvent event) {
      setTipo(event.getNewValue().toString());
   }

   public String getMaskNroContato() {
      return maskNroContato;
   }

   public void setMaskNroContato(String maskNroContato) {
      this.maskNroContato = maskNroContato;
   }

   public String getMaskAreaContato() {
      return maskAreaContato;
   }

   public void setMaskAreaContato(String maskAreaContato) {
      this.maskAreaContato = maskAreaContato;
   }

   public String getTipo() {
      return tipo;
   }

   public void setTipo(String tipo) {
      this.tipo = tipo;
   }

}
