package br.com.devdojo.javacore.datas.test;

import java.util.Calendar;
import java.util.Date;

public class ManipulacaoDeDatasTest {
    public static void main(String[] args) {
        Date date = new Date(); //Data atual
//        System.out.println(date);

        Calendar c = Calendar.getInstance();
//        System.out.println(c);
        c.setTime(date); //transpondo um objeto antigo date é um Calendar
        if(Calendar.SUNDAY == c.getFirstDayOfWeek()){
            System.out.println("Domingo é o primeiro dia da semana");
        }
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
        System.out.println(c.get(Calendar.DAY_OF_YEAR));
        c.add(Calendar.HOUR,10);
//        c.roll(Calendar.MONTH,10); //Não rotacionar o ano, dia, semana.
        Date date2 = c.getTime();
        System.out.println(date2);

    }
}
