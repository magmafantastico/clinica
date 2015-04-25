/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.magmadoctor.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Dirceu Junior
 */
public class DateFunctions {

    SimpleDateFormat formatHour;
    SimpleDateFormat formatDate;
    SimpleDateFormat formatFull;

    public DateFunctions() {
        this.formatDate = new SimpleDateFormat("dd/MM/yyyy");
        this.formatHour = new SimpleDateFormat("HH:mm:ss");
        this.formatFull = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    }

    /**
     * Adiciona quantidade de dias na data.
     *
     * @param data
     * @param qtd
     * @return
     */
    public static Date addDia(Date data, int qtd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DAY_OF_MONTH, qtd);
        return cal.getTime();
    }

    /**
     * Adiciona quantidade de meses na data.
     *
     * @param data
     * @param qtd
     * @return
     */
    public static Date addMes(Date data, int qtd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.MONTH, qtd);
        return cal.getTime();
    }

    /**
     * Adiciona quantidade de anos na data.
     *
     * @param data
     * @param qtd
     * @return
     */
    public static Date addAno(Date data, int qtd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.YEAR, qtd);
        return cal.getTime();
    }

    /**
     * Método que faz uma comparação entre Calendar considerando apenas dia, mês
     * e ano.
     *
     * @param data1 Uma data qualquer
     * @param data2 Uma data qualquer
     * @return -1 quando a data1 é menor, 0 quando são iguais ou 1 quando é
     * maior.
     */
    public int comparaData(Calendar data1, Calendar data2) {
        int retorno = 0;
        int dia1 = data1.get(Calendar.DATE);
        int mes1 = data1.get(Calendar.MONTH);
        int ano1 = data1.get(Calendar.YEAR);
        int dia2 = data2.get(Calendar.DATE);
        int mes2 = data2.get(Calendar.MONTH);
        int ano2 = data2.get(Calendar.YEAR);

        if (ano1 < ano2) {
            retorno = -1;
        } else if (ano1 > ano2) {
            retorno = 1;
        } else {
            if (mes1 < mes2) {
                retorno = -1;
            } else if (mes1 > mes2) {
                retorno = 1;
            } else {
                if (dia1 < dia2) {
                    retorno = -1;
                } else if (dia1 > dia2) {
                    retorno = 1;
                }
            }
        }
        return retorno;
    }

    /**
     * Converte uma String para um objeto Date. Caso a String seja vazia ou
     * nula, retorna null - para facilitar em casos onde formulários podem ter
     * campos de datas vazios.
     *
     * @param data String no formato dd/MM/yyyy a ser formatada
     * @return Date Objeto Date ou null caso receba uma String vazia ou nula
     * @throws Exception Caso a String esteja no formato errado
     */
    public static Date formataData(String data) throws Exception {
        if (data == null || data.equals("")) {
            return null;
        }
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date) formatter.parse(data);
        } catch (ParseException e) {
            throw e;
        }
        return date;
    }

    /**
     * Retorna o valor do horário minimo para a data de referencia passada.
     * <BR>
     * <BR> Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
     * retornada por este metodo será "30/01/2009 as 00h:00m:00s e 000ms".
     *
     * @param date de referencia.
     * @return {@link Date} que representa o horário minimo para dia informado.
     */
    public static Date lowDateTime(Date date) {
        Calendar aux = Calendar.getInstance();
        aux.setTime(date);
        toOnlyDate(aux); //zera os parametros de hour,min,sec,milisec  
        return aux.getTime();
    }

    /**
     * Retorna o valor do horário maximo para a data de referencia passada.
     * <BR>
     * <BR> Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
     * retornada por este metodo será "30/01/2009 as 23h:59m:59s e 999ms".
     *
     * @param date de referencia.
     * @return {@link Date} que representa o horário maximo para dia informado.
     */
    public static Date highDateTime(Date date) {
        Calendar aux = Calendar.getInstance();
        aux.setTime(date);
        toOnlyDate(aux); //zera os parametros de hour,min,sec,milisec  
        aux.roll(Calendar.DATE, true); //vai para o dia seguinte  
        aux.roll(Calendar.MILLISECOND, false); //reduz 1 milisegundo  
        return aux.getTime();
    }

    /**
     * Zera todas as referencias de hora, minuto, segundo e milesegundo do
     * {@link Calendar}.
     *
     * @param date a ser modificado.
     */
    public static void toOnlyDate(Calendar date) {
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
    }

}
