package br.com.devdojo.javacore.datas.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {
    public static void main(String[] args) {
        float valor = 123212.4567f;
        float valor2 = 212.4567f;
        Locale locJapao = new Locale("jp");
        Locale locFranca = new Locale("fr");
        Locale locItaly = new Locale("it");
        Locale locEua = new Locale("en");

        NumberFormat[] nfa = new NumberFormat[4];//só instanciamos porque é um array pois a classe NumberFormat é abstrata

        nfa[0] = NumberFormat.getInstance();
        nfa[1] = NumberFormat.getInstance(locEua);
        nfa[2] = NumberFormat.getCurrencyInstance();
        nfa[3] = NumberFormat.getCurrencyInstance(locEua);

        for (NumberFormat nf : nfa) {
            System.out.println(nf.format(valor2));
        }

        NumberFormat nf = NumberFormat.getInstance();
        System.out.println(nf.getMaximumFractionDigits());
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(valor2));


        String valorString = "212,4567";
        try {
            System.out.println(nf.parse(valorString));
            nf.setParseIntegerOnly(true); // Desconsiderar os valore decimais
            System.out.println(nf.parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
