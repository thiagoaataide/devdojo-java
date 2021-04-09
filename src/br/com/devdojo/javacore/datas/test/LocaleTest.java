package br.com.devdojo.javacore.datas.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        //ISO 639 pt = Portubês, BR - Brasil; en - ingles, US - Estados Unidos
        Locale locItaly = new Locale("it","IT");
        Locale locSuica = new Locale("it","CH");
        Locale locBrasil = new Locale("pt","BR");
        Locale locIndia = new Locale("hi","In");
        Locale locJapao = new Locale("ja");
        Calendar c = Calendar.getInstance();
        c.set(2015,Calendar.DECEMBER,23);
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL,locItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,locSuica);
        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL,locBrasil);
        DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL,locIndia);
        DateFormat df5 = DateFormat.getDateInstance(DateFormat.FULL,locJapao);
        System.out.println("Itália: " + df.format(c.getTime()));
        System.out.println("Suiça: " + df2.format(c.getTime()));
        System.out.println("Brasil: " + df3.format(c.getTime()));
        System.out.println("India: " + df4.format(c.getTime()));
        System.out.println("Japão: " + df5.format(c.getTime()));

        System.out.println(locItaly.getDisplayLanguage());
        System.out.println(locJapao.getDisplayLanguage());
        System.out.println(locSuica.getDisplayCountry(locItaly));// traduziu o nome Suiça para Italiano


    }
}
